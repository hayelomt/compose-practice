package com.example.composeapplication.src.todo.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.composeapplication.src.todo.TodoViewModel

@Composable
fun TodoScreen(todoViewModel: TodoViewModel) {
    val todoList by todoViewModel.todoItems.observeAsState(listOf())

    TodoContainer(
        todoList = todoList,
        currentlyEditing = todoViewModel.currentEditItem,
        onAddItem = todoViewModel::addItem,
        onItemClicked = todoViewModel::onEditStart,
        onEditDone = todoViewModel::onEditDone,
        onRemove = todoViewModel::removeItem
    )
}