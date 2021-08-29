package com.example.composeapplication.src.todo.repository

import com.example.composeapplication.src.todo.TodoDao
import com.example.composeapplication.src.todo.TodoItem
import kotlinx.coroutines.flow.Flow

class TodoDbRepository(
    private val dataSource: TodoDao
): ITodoRepository {
    override suspend fun insertTodo(todoItem: TodoItem) = dataSource.insertTodoItem(todoItem)

    override fun getTodos(): Flow<List<TodoItem>> = dataSource.getItems()

    override suspend fun getItem(id: Int): TodoItem? = dataSource.getItem(id)

    override suspend fun removeItem(todoItem: TodoItem) = dataSource.deleteItem(todoItem)

    override suspend fun updateItem(todoItem: TodoItem) = dataSource.updateItem(todoItem)
}