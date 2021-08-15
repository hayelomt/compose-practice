package com.example.composeapplication.src.main.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.src.todo.TodoViewModel
import com.example.composeapplication.src.todo.components.TodoScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen ) {
        composable(Screens.MainScreen) {
            val todoViewModel: TodoViewModel = hiltViewModel()

            TodoScreen(
                todoList = todoViewModel.todoItems,
                currentlyEditing = todoViewModel.currentEditItem,
                onAddItem = todoViewModel::addItem,
                onItemClicked = todoViewModel::onEditStart,
                onEditTextChange = todoViewModel::onEditTextChange,
                onEditDone = todoViewModel::onEditDone,
                onRemove = todoViewModel::removeItem
            )
        }
    }
}
