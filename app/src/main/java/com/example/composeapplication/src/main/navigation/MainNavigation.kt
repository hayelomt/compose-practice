package com.example.composeapplication.src.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.src.todo.TodoItem
import com.example.composeapplication.src.todo.components.TodoScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen ) {
        composable(Screens.MainScreen) {
            TodoScreen(
                todoList = listOf(TodoItem("Start Todo")),
                currentlyEditing = null,
                onAddItem = {},
                onItemClicked = {},
                onEditTextChange = {},
                onEditDone = { /*TODO*/ },
                onRemove = { /*TODO*/ }
            )
        }
    }
}