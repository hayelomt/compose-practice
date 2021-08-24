package com.example.composeapplication.src.todo.repository

import androidx.lifecycle.LiveData
import com.example.composeapplication.src.todo.TodoItem

interface ITodoRepository {
    suspend fun insertTodo(todoItem: TodoItem)

    fun getTodos(): LiveData<List<TodoItem>>

    suspend fun getItem(id: Int): TodoItem?

    suspend fun removeItem(todoItem: TodoItem)

    suspend fun updateItem(todoItem: TodoItem)
}