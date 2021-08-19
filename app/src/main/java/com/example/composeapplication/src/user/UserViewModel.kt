package com.example.composeapplication.src.user

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.shared.network.NetworkResponse
import com.example.composeapplication.shared.utils.Constants
import com.example.composeapplication.src.user.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    fun getUser() {
        viewModelScope.launch {
            Log.d(Constants.TAG, "Start Fetch user")

            when (val response = userRepository.getUser(1)) {
                is NetworkResponse.Success -> {
                    Log.d(Constants.TAG, "User ${response.data!!.name}")
                }
                is NetworkResponse.Error -> {
                    Log.d(Constants.TAG, "Api Error ${response.message}")
                }
            }
        }
    }
}