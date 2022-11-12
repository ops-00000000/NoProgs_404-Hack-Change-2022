package com.dev.hackchange2022

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.hackchange2022.screens.ChatScreen
import com.dev.hackchange2022.screens.LoginScreen

sealed class Screans(val route: String){
    object Login : Screans(route = Constants.Screens.LOGIN_SCREEN)
    object Chat : Screans(route = Constants.Screens.CHAT_SCREEN)
}

    @Composable
    fun MyAppNavHost(
        navController: NavHostController, viewModel : MainViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = Screans.Login.route
        ) {
            composable(route = Screans.Login.route) {
                LoginScreen(
                    onNavigateToChat = { navController.navigate(Screans.Chat.route) },navController = navController, viewModel= viewModel
                )
            }
            composable(Screans.Chat.route) { ChatScreen(navController = navController, viewModel= viewModel) }
        }
    }
