package com.example.composeapplication.src.todo

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.composeapplication.shared.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(): ViewModel() {
    var todoItems = mutableListOf<TodoItem>()
        private set

    var currentEditItemIndex = -1
    val currentEditItem: TodoItem?
        get()  = todoItems.getOrNull(currentEditItemIndex)

    fun addItem(todoItem: TodoItem) {
        Log.d(Constants.TAG, "Add Todo $todoItem")
        todoItems.add(todoItem)
    }

    fun onEditStart(todoItem: TodoItem) {
        currentEditItemIndex = todoItems.indexOf(todoItem)
    }

    fun onEditTextChange(todoText: String) {
        currentEditItem?.let {
            todoItems[currentEditItemIndex] = TodoItem(todoText)
        }
    }

    fun onEditDone() {
        currentEditItemIndex = -1
    }

    fun removeItem(todoItem: TodoItem) {
        todoItems.remove(todoItem)
    }
}