package com.example.composeapplication.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    var pk: Int? = null,

    var title: String? = null,

    @SerializedName("featured_image")
    var featuredImage: String? = null,

    var publisher: String? = null,

    var rating: Int? = null,

    @SerializedName("source_url")
    var sourceUrl: String? = null,

    var description: String? = null,

    @SerializedName("cooking_instructions")
    var cookingInstructions: String? = null,

    @SerializedName("ingredients")
    var ingredients: List<String>? = null,

    @SerializedName("date_added")
    var dateAdded: String? = null,

    @SerializedName("date_updated")
    var dateUpdated: String? = null
)