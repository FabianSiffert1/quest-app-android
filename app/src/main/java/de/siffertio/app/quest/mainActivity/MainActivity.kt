package de.siffertio.app.quest.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import de.siffertio.app.quest.NavGraphs
import de.siffertio.app.quest.components.bottomNavigationBar.BottomNavigationBar
import de.siffertio.app.quest.ui.theme.QuestTheme
import defaultTransitions

@OptIn(
    ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val engine = rememberAnimatedNavHostEngine(rootDefaultAnimations = defaultTransitions)
            val navController = engine.rememberNavController()
            QuestTheme {
                Scaffold(bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuestTheme {}
}
