import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations

@OptIn(ExperimentalAnimationApi::class)
val defaultTransitions: RootNavGraphDefaultAnimations =
    RootNavGraphDefaultAnimations(
        enterTransition = {
            slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(700))
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(700))
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(700))
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(700))
        }
    )