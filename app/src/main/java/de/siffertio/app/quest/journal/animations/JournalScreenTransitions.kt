package de.siffertio.app.quest.journal.animations

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.DestinationStyle
import com.ramcosta.composedestinations.utils.navGraph
import de.siffertio.app.quest.NavGraphs

@OptIn(ExperimentalAnimationApi::class)
object JournalScreenTransitions : DestinationStyle.Animated {

    override fun AnimatedContentScope<NavBackStackEntry>.enterTransition(): EnterTransition? {
        return when (initialState.navGraph()) {
            NavGraphs.HomeNavGraph ->
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(200))
            NavGraphs.SettingsNavGraph ->
                slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(200))
            else -> {
                slideInHorizontally(initialOffsetX = { 1000 }, animationSpec = tween(200))
            }
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.exitTransition(): ExitTransition? {
        return when (targetState.navGraph()) {
            NavGraphs.HomeNavGraph ->
                slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(200))
            NavGraphs.SettingsNavGraph ->
                slideOutHorizontally(targetOffsetX = { -1000 }, animationSpec = tween(200))
            else -> slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(200))
        }
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popEnterTransition(): EnterTransition? {
        return slideInHorizontally(initialOffsetX = { -1000 }, animationSpec = tween(200))
    }

    override fun AnimatedContentScope<NavBackStackEntry>.popExitTransition(): ExitTransition? {
        return slideOutHorizontally(targetOffsetX = { 1000 }, animationSpec = tween(200))
    }
}
