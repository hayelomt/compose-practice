package com.example.composeapplication.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapplication.domain.model.Recipe

@Composable
fun RecipeList(recipes: List<Recipe>, searchBar: @Composable () -> Unit) {

    Column {
        searchBar()
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn {
            items(100) {
                RecipeCard(recipe = Recipe(title = "Burger", featuredImage = "Image")) {
                }
            }
        }
    }
}

@Composable
fun SearchBar(text: String, onTextChange: (String) -> Unit) {
    TextField(text, onTextChange)
}