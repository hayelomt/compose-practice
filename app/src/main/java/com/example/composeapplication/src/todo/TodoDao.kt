package com.example.composeapplication.src.todo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * from todo_items ORDER BY id ASC")
    fun getItems(): LiveData<List<TodoItem>>

    @Insert
    suspend fun insertTodoItem(todoItem: TodoItem)
}