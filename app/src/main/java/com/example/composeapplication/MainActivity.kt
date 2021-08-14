package com.example.composeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.presentation.components.RecipeList
import com.example.composeapplication.presentation.components.SearchBar
import com.example.composeapplication.presentation.ui.recipe_list.RecipeListViewModel
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.d("Main", viewModel.query.value)
        setContent {
            RecipeScreen(
                viewModel
            )
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun RecipeScreen(viewModel: RecipeListViewModel) {
    ComposeApplicationTheme {
        RecipeList(
            viewModel
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeScreen() {
//    RecipeScreen()
}