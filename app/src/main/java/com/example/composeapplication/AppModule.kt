package com.example.composeapplication

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(MainActivity::class)
object AppModule {
    @Provides
    fun provideSample(): Sample {
        return Sample()
    }
}