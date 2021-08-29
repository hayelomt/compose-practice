package com.example.composeapplication.src.todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.src.todo.repository.ITodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepository: ITodoRepository
): ViewModel() {
    val todoItems: LiveData<List<TodoItem>> = todoRepository.getTodos().asLiveData()

    var currentEditItem: TodoItem? by mutableStateOf(null)
        private set

    fun addItem(todoItem: TodoItem) {
        viewModelScope.launch {
            todoRepository.insertTodo(todoItem)
        }
    }

    fun onEditStart(todoItem: TodoItem) {
        viewModelScope.launch {
            todoRepository.getItem(todoItem.id).let {
                currentEditItem = it
            }
        }
    }

    fun onEditDone(todoItem: TodoItem) {
        viewModelScope.launch {
            todoRepository.updateItem(todoItem)
            currentEditItem = null
        }
    }

    fun removeItem(todoItem: TodoItem) {
        viewModelScope.launch {
            todoRepository.removeItem(todoItem)
        }
        currentEditItem = null
    }
}