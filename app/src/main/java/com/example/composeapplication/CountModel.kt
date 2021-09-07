package com.example.composeapplication


import com.google.gson.annotations.SerializedName

data class CountModel(
    @SerializedName("count")
    val count: Count?
) {
    data class Count(
        @SerializedName("count")
        val count: Int?,
        @SerializedName("player")
        val player: String?
    )
}