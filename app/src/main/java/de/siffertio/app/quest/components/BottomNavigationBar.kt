package de.siffertio.app.quest.components

import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import de.siffertio.app.quest.R
import de.siffertio.app.quest.home.NavGraph
import de.siffertio.app.quest.home.NavGraphs
import de.siffertio.app.quest.ui.theme.QuestTheme

enum class BottomBarDestination(
    val navGraph: NavGraph,
    val icon: ImageVector,
    @StringRes val label: Int
) {
    Home(NavGraphs.HomeNavGraph, Icons.Default.Home, R.string.home_screen),
}

@Composable
fun BottomNavigationBar(navHostController: NavHostController) {
    BottomNavigation(backgroundColor = Color.Transparent, elevation = 0.dp) {
        BottomBarDestination.values().forEach { destination ->
            val isCurrentDestOnBackStack = true
            BottomNavigationItem(
                selected = isCurrentDestOnBackStack,
                onClick = {
                    navHostController.backQueue.forEach { item ->
                        if (destination.navGraph.route == item.destination.route) {
                            navHostController.popBackStack(
                                route = destination.navGraph.route,
                                inclusive = false,
                                saveState = false
                            )
                            return@BottomNavigationItem
                        }
                    }

                    navHostController.navigate(destination.navGraph.route) {
                        popUpTo(NavGraphs.root.route) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(destination.icon, contentDescription = stringResource(destination.label))
                },
                label = { Text(stringResource(destination.label)) },
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    QuestTheme() { BottomNavigationBar(navHostController = rememberNavController()) }
}
