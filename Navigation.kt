package com.example.rakshaapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigator(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        // Splash Screen

        composable("splash") {

            SplashScreen(navController)
        }

        // Login Screen
        composable("login") {
            LoginScreen(navController)
        }

        // Register Screen
        composable("register") {
            RegisterScreen(navController)
        }

        // Dashboard Screen
        composable("dashboard") {
            DashboardScreen(navController)
        }

        // Emergency Contacts Screen
        composable("contacts") {
            ContactsScreen(navController)
        }

        // Location Screen
        composable("location") {
            LocationScreen(navController)
        }

        // Safety Tips Screen
        composable("tips") {
            TipsScreen(navController)
        }

        // Settings Screen
        composable("settings") {
            SettingsScreen(navController)
        }

        // Emergency Helpline Screen
        composable("helpline") {
            HelplineScreen(navController)
        }
    }
}