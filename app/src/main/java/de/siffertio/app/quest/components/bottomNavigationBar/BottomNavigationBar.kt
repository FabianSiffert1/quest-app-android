package de.siffertio.app.quest.components.bottomNavigationBar

import androidx.annotation.StringRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import de.siffertio.app.quest.NavGraph
import de.siffertio.app.quest.NavGraphs
import de.siffertio.app.quest.R
import de.siffertio.app.quest.ui.theme.QuestTheme

enum class BottomBarDestination(
    val navGraph: NavGraph,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Home(NavGraphs.HomeNavGraph, Icons.Default.Home, R.string.home_screen),
    Journal(NavGraphs.JournalNavGraph, Icons.Default.DateRange, R.string.journal_screen),
    Settings(NavGraphs.SettingsNavGraph, Icons.Default.Settings, R.string.settings_screen)
}

@Composable
fun BottomNavigationBar(navHostController: NavHostController) = QuestTheme {
    val contentColor = LocalContentColor.current
    val textColor: Color = if (isSystemInDarkTheme()) Color.White else Color.Black

    NavigationBar(containerColor = Color.Transparent, contentColor = Color.Transparent) {
        BottomBarDestination.values().forEach { destination ->
            val isCurrentDestOnBackStack = true
            NavigationBarItem(
                selected = isCurrentDestOnBackStack,
                onClick = { navigateToBottomBarDestination(navHostController, destination) },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = stringResource(destination.label),
                        tint = contentColor
                    )
                },
                colors =
                    NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
                        indicatorColor = MaterialTheme.colorScheme.surface
                    ),
                label = { Text(text = stringResource(destination.label), color = textColor) },
            )
        }
    }
}

private fun navigateToBottomBarDestination(
    navHostController: NavHostController,
    destination: BottomBarDestination
) {

    navHostController.backQueue.forEach { item ->
        if (destination.navGraph.route == item.destination.route) {
            navHostController.popBackStack(
                route = destination.navGraph.route,
                inclusive = false,
                saveState = false
            )
            return
        }
    }

    navHostController.navigate(destination.navGraph.route) {
        popUpTo(NavGraphs.root.route) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }

    navHostController.backQueue.forEach { item -> run { println(item.destination) } }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    QuestTheme() {
        BottomNavigationBar(
            navHostController = rememberNavController(),
        )
    }
}
