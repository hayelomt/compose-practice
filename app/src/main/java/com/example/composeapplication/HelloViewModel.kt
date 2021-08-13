package com.example.composeapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HelloViewModel @Inject constructor(): ViewModel() {
    private var _name by mutableStateOf("")
    val name: String get() = _name

    fun onNameChange(newName: String) {
        _name = newName
    }
}