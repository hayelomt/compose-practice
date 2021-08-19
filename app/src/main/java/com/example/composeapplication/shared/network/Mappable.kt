package com.example.composeapplication.shared.network

interface Mappable<out T: Any> {
    fun mapToModel(): T
}