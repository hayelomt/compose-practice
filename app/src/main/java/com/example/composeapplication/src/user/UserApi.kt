package com.example.composeapplication.src.user

import com.example.composeapplication.src.user.models.UserDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users/{userId}")
    suspend fun getUser(@Path("userId")  userId: Int): Response<UserDto>
}