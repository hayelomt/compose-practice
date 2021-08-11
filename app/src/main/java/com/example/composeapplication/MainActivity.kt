package com.example.composeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.presentation.components.RecipeList
import com.example.composeapplication.presentation.components.SearchBar
import com.example.composeapplication.presentation.ui.recipe_list.RecipeListViewModel
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Main", viewModel.query.value)
        setContent {
//            RecipeScreen(
//                query = viewModel.query.value,
//                onQueryChange = {
//                    //
//                }
//            )
        }
    }
}

@Composable
fun RecipeScreen(
    query: String,
    onQueryChange: (String) -> Unit
) {
    ComposeApplicationTheme {
//        RecipeList(
//            recipes = listOf(),
//            searchBar = {
//                SearchBar(text = query, onQueryChange)
//            }
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeScreen() {
//    RecipeScreen()
}