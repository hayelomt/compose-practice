package com.example.composeapplication.network.responses

import com.example.composeapplication.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    var count: Int,

    @SerializedName("result")
    var recipes: List<RecipeDto>
)