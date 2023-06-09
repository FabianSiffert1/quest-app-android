package de.siffertio.app.quest.mainActivity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import de.siffertio.app.quest.NavGraphs
import de.siffertio.app.quest.components.bottomNavigationBar.BottomNavigationBar
import de.siffertio.app.quest.components.quests.ui.startQuestButton.StartQuestButton
import de.siffertio.app.quest.ui.theme.QuestTheme
import defaultTransitions

@OptIn(
    ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val engine = rememberAnimatedNavHostEngine(rootDefaultAnimations = defaultTransitions)
            val navController = engine.rememberNavController()
            QuestTheme {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = !isSystemInDarkTheme()
                systemUiController.setStatusBarColor(
                    color = MaterialTheme.colorScheme.surface,
                    darkIcons = useDarkIcons
                )
                systemUiController.setNavigationBarColor(color = MaterialTheme.colorScheme.surface)
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController) },
                    floatingActionButton = {
                        StartQuestButton(onClick = { println("start new quest") })
                    }
                ) { innerPadding ->
                    DestinationsNavHost(
                        engine = engine,
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        navGraph = NavGraphs.root
                    )
                }
            }
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class
)
@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    QuestTheme {
        //        Scaffold(
        //            bottomBar = { BottomNavigationBar() },
        //            floatingActionButton = { StartQuestButton(onClick = { println("start new
        // quest") }) }
        //        ) { innerPadding ->
        //            DestinationsNavHost(
        //                engine = rememberAnimatedNavHostEngine(),
        //                navController = rememberNavController(),
        //                modifier = Modifier.padding(innerPadding),
        //                navGraph = NavGraphs.root
        //            )
        //        }
    }
}
