package com.example.composeapplication.src.todo.repository

import androidx.lifecycle.LiveData
import com.example.composeapplication.src.todo.dataSource.TodoDao
import com.example.composeapplication.src.todo.TodoItem

class TodoDbRepository(
    private val dataSource: TodoDao
): ITodoRepository {
    override suspend fun insertTodo(todoItem: TodoItem) = dataSource.insertTodoItem(todoItem)

    override fun getTodos(): LiveData<List<TodoItem>> = dataSource.getItems()

    override suspend fun getItem(id: Int): TodoItem? = dataSource.getItem(id)

    override suspend fun removeItem(todoItem: TodoItem) = dataSource.deleteItem(todoItem)

    override suspend fun updateItem(todoItem: TodoItem) = dataSource.updateItem(todoItem)
}