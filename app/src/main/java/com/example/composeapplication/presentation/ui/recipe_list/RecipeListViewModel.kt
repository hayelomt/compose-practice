package com.example.composeapplication.presentation.ui.recipe_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composeapplication.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
): ViewModel() {
    val query = mutableStateOf("")

    fun onQueryChange(newQuery: String) {
        query.value = newQuery
    }
}