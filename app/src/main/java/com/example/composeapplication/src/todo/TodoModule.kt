package com.example.composeapplication.src.todo

import com.example.composeapplication.shared.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Singleton
    @Provides
    fun provideTodoDao(todoDb: TodoDatabase): TodoDao = todoDb.todoDao()

}