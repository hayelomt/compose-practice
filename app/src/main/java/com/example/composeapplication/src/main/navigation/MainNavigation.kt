package com.example.composeapplication.src.main.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.src.todo.TodoViewModel
import com.example.composeapplication.src.todo.components.TodoScreen
import com.example.composeapplication.src.user.components.UserScreen
import com.example.composeapplication.src.user.UserViewModel

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.TODO_SCREEN ) {
        composable(Screens.USER_SCREEN) {
            val userViewModel: UserViewModel = hiltViewModel()
            UserScreen(userViewModel)
        }
        composable(Screens.TODO_SCREEN) {
            val todoViewModel: TodoViewModel = hiltViewModel()
            TodoScreen(todoViewModel)
        }
    }
}
