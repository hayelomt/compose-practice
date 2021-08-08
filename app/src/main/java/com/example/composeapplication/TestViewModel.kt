package com.example.composeapplication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class TestViewModel @Inject constructor(
    @Named("TestString") val testString: String
) : ViewModel() {
    fun getTest() = "ViewModel - $testString"
}