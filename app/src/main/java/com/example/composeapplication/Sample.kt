package com.example.composeapplication

import javax.inject.Inject

class Sample @Inject constructor() {
    fun hello(): String {
        return "Hello"
    }
}