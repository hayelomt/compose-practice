package com.example.composeapplication.shared.network

sealed class NetworkResponse<out T : Any>(val data: T? = null, val message: String? = null) {
    class Success<out T : Any>(data: T) : NetworkResponse<T>(data)
    class Error<out T: Any>(message: String, data: T? = null) :
        NetworkResponse<T>(data = data, message = message)
}