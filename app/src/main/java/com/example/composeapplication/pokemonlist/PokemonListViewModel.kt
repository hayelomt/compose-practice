package com.example.composeapplication.pokemonlist

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.composeapplication.data.models.PokedexListEntry
import com.example.composeapplication.repository.PokemonRepository
import com.example.composeapplication.utils.Constants.PAGE_SIZE
import com.example.composeapplication.utils.Resource
import com.example.composeapplication.utils.calculateDominantColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
):  ViewModel() {

    private var curPage = 0

    var pokemonList = mutableStateOf<List<PokedexListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    init {
        loadPokemonPaginated()
    }

    fun loadPokemonPaginated() {
        viewModelScope.launch {
            isLoading.value = true
            when(val result = repository.getPokemonList(PAGE_SIZE, PAGE_SIZE * curPage)) {
                is Resource.Success -> {
//                    endReached.value = curPage * PAGE_SIZE >= result.data!!.count
                    endReached.value = true
                    val pokedexEntries = result.data!!.results.mapIndexed { _, entry ->
                        val number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
                        PokedexListEntry(pokemonName = entry.name.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.ROOT
                            ) else it.toString()
                        }, number = number.toInt(), imageUrl = url)
                    }
                    curPage++
                    loadError.value = ""
                    pokemonList.value += pokedexEntries
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    Log.d("VIEW_MODEL", result.message!!)
                }
            }
            isLoading.value = false
        }
    }

    fun calcDominantFromUrl(context: Context, imageUrl: String, onFinish: (Color) -> Unit) {
        viewModelScope.launch {
            calculateDominantColor(context, imageUrl) { onFinish(it) }
        }
    }
}