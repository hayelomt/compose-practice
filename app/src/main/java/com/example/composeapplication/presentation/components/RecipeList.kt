package com.example.composeapplication.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.composeapplication.presentation.ui.recipe_list.RecipeListViewModel

@ExperimentalComposeUiApi
@Composable
fun RecipeList(viewModel: RecipeListViewModel) {
    val recipes = viewModel.recipes.value
    val query = viewModel.query.value

    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
            ,
            color = MaterialTheme.colors.primary,
            elevation = 8.dp,
        ){
            Row(modifier = Modifier.fillMaxWidth()){
                TextField(
                    value = query,
                    onValueChange = viewModel::onQueryChanged,
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .padding(8.dp),
                    label = {
                        Text(text = "Search")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            viewModel.newSearch(query)
                            keyboardController?.hide()
                        }
                    ),
                    textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                )
            }
        }

        LazyColumn {
            itemsIndexed(
                items = recipes
            ){ _, recipe ->
                RecipeCard(recipe = recipe, onClick = {})
            }
        }
    }
}

@Composable
fun SearchBar(text: String, onTextChange: (String) -> Unit) {
    TextField(text, onTextChange)
}