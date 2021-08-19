package com.example.composeapplication.shared.network

import retrofit2.Response

abstract class NetworkRepository {
     protected  suspend fun <T : Any,K: Mappable<T>> makeApiCall(apiCall: suspend () -> Response<K>): NetworkResponse<T> {
        return try {
            val response = apiCall()
            if (response.isSuccessful) {
                NetworkResponse.Success(response.body()!!.mapToModel())
            } else {
                NetworkResponse.Error(message = "")
            }
        } catch (e: Exception) {
            NetworkResponse.Error(message = "")
        }
    }
}