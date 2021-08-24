package com.example.composeapplication.shared

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeapplication.src.todo.TodoDao
import com.example.composeapplication.src.todo.TodoItem

@Database(
    entities = [TodoItem::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
}