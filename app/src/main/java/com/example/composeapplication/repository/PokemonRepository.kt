package com.example.composeapplication.repository

import com.example.composeapplication.data.remote.PokeApi
import com.example.composeapplication.data.remote.responses.Pokemon
import com.example.composeapplication.data.remote.responses.PokemonList
import com.example.composeapplication.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val api: PokeApi) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return try {
            Resource.Success(api.getPokemonList(limit, offset))
        } catch(e: Exception) {
            Resource.Error("An Unknown error occurred")
        }
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        return try {
            Resource.Success(api.getPokemon(name))
        } catch (e: Exception) {
            Resource.Error("An Unknown error occurred")
        }
    }
}