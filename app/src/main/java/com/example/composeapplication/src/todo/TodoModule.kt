package com.example.composeapplication.src.todo

import com.example.composeapplication.shared.TodoDatabase
import com.example.composeapplication.src.todo.dataSource.TodoDao
import com.example.composeapplication.src.todo.repository.ITodoRepository
import com.example.composeapplication.src.todo.repository.TodoDbRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Singleton
    @Provides
    fun provideTodoDao(todoDb: TodoDatabase): TodoDao = todoDb.todoDao()

    @Singleton
    @Provides
    fun provideTodoRepository(dataSource: TodoDao): ITodoRepository = TodoDbRepository(dataSource)

    @Singleton
    @Provides
    @Named("TODO_REF")
    fun provideTodoRef(database: FirebaseDatabase): DatabaseReference = database.getReference("todos")
}