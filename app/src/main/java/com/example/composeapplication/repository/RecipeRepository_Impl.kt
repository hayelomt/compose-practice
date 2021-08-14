package com.example.composeapplication.repository

import android.util.Log
import com.example.composeapplication.domain.model.Recipe
import com.example.composeapplication.network.RecipeService
import com.example.composeapplication.network.model.RecipeDtoMapper

class RecipeRepository_Impl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper
): RecipeRepository {
    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        val recipes = recipeService.search(token, page, query).recipes;
        Log.d("RECIPE", "$recipes")
        return mapper.toDomainList(recipes ?: listOf())
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token, id))
    }
}