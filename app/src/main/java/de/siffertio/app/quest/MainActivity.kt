package de.siffertio.app.quest

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
import androidx.core.view.WindowCompat
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import de.siffertio.app.quest.home.NavGraphs
import de.siffertio.app.quest.koin.appModule
import de.siffertio.app.quest.ui.theme.QuestTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@OptIn(
    ExperimentalMaterialNavigationApi::class,
    ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(appModule)
        }
        setContent {
            val engine = rememberAnimatedNavHostEngine()
            val navController = engine.rememberNavController()
            QuestTheme {
                Scaffold() { innerPadding ->
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
