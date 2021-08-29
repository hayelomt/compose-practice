package com.example.composeapplication.src.todo.repository

import com.example.composeapplication.src.todo.TodoItem
import kotlinx.coroutines.flow.Flow

interface ITodoRepository {
    suspend fun insertTodo(todoItem: TodoItem)

    fun getTodos(): Flow<List<TodoItem>>

    suspend fun getItem(id: Int): TodoItem?

    suspend fun removeItem(todoItem: TodoItem)

    suspend fun updateItem(todoItem: TodoItem)
}