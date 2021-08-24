package com.example.composeapplication.src.user.repository

import com.example.composeapplication.shared.network.NetworkRepository
import com.example.composeapplication.src.user.UserApi
import javax.inject.Inject
import javax.inject.Singleton
import com.example.composeapplication.shared.network.NetworkResponse
import com.example.composeapplication.src.user.models.User

@Singleton
class UserRepository @Inject constructor(
    private val userApi: UserApi
): NetworkRepository() {

//    suspend fun getUser(userId: Int): NetworkResponse<User> {
//        return try {
//            val response = userApi.getUser(userId)
//            if (response.isSuccessful) {
//                NetworkResponse.Success(response.body()!!.mapToModel())
//            } else {
//                Log.d(Constants.TAG, "Response not success ${response.code()}")
//                NetworkResponse.Error(message = "Error ${response.code()} ${response.message()}")
//            }
//        } catch (e: Exception) {
//            Log.d(Constants.TAG, "Error $e")
//            NetworkResponse.Error(message = "Error ${e.message}")
//        }
//    }
    suspend fun getUser(userId: Int): NetworkResponse<User> {
        return makeApiCall {
            userApi.getUser(userId)
        }
    }
}