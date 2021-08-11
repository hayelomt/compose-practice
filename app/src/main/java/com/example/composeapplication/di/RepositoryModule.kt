package com.example.composeapplication.di

import com.example.composeapplication.network.RecipeService
import com.example.composeapplication.network.model.RecipeDtoMapper
import com.example.composeapplication.repository.RecipeRepository
import com.example.composeapplication.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository = RecipeRepository_Impl(recipeService, recipeDtoMapper)
}