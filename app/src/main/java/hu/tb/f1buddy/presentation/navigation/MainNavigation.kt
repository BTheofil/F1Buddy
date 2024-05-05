package hu.tb.f1buddy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hu.tb.f1buddy.presentation.screens.main.MainScreen

@Composable
fun MainNavigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "MainScreen") {

        composable(route = "MainScreen"){
            MainScreen()
        }
    }
}