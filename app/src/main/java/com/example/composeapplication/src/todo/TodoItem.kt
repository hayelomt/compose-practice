package com.example.composeapplication.src.todo

import java.util.*

data class TodoItem(val todo: String, val id: UUID = UUID.randomUUID())