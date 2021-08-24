package com.example.composeapplication.src.main.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.src.user.components.UserScreen
import com.example.composeapplication.src.user.UserViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.USER_SCREEN ) {
        composable(Screens.USER_SCREEN) {
            val userViewModel: UserViewModel = hiltViewModel()
            UserScreen(userViewModel)
        }
    }
}
