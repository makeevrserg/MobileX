package com.makeevrserg.mvvm_core.presentation.compose

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.makeevrserg.mvvmcore.core.routing.IRouter

@ExperimentalAnimationApi
private fun slideInAnimation(): (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?) =
    { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300)) }

@ExperimentalAnimationApi
private fun slideOutAnimation(): (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?) =
    { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(300)) }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
    navController: NavHostController,
    viewModelStoreOwner: ViewModelStoreOwner,
) {
    val navRouter: IRouter<ComposeScreen> = NavHostRouter(navController, viewModelStoreOwner)

    AnimatedNavHost(
        navController = navController,
        startDestination = ComposeScreen.Main.route,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(
            route = ComposeScreen.Main.route,
            enterTransition = slideInAnimation(),
            exitTransition = slideOutAnimation()
        ) {
            MainScreen(navRouter)
        }
        composable(
            route = ComposeScreen.Custom.route + "?string={string}",
            enterTransition = slideInAnimation(),
            exitTransition = slideOutAnimation(),
            arguments = listOf(navArgument("string") {
                type = NavType.StringType
            })
        ) {
            CustomScreen(navRouter, it.arguments?.getString("string") ?: "null")
        }
    }
}