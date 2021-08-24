package com.example.composeapplication.src.user.models

data class User(
    val id: Int,
    val name: String = "",
    val username: String = "",
    val email: String = ""
)