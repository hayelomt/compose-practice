package com.example.composeapplication.src.todo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(): ViewModel() {
    val todoItems: List<TodoItem> = listOf(TodoItem("Item 1"), TodoItem("Item 2"))
}