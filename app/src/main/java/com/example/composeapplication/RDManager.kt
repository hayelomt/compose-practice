package com.example.composeapplication

import com.google.firebase.database.FirebaseDatabase

class RDManager {
    private val databaseReference = FirebaseDatabase.getInstance().reference
    private val database = FirebaseDatabase.getInstance()
    private val myRef = database.getReference("message")

    fun addDummyData() {
//        databaseReference('message').setValue("Saving data on android")
        myRef.setValue("Hello Today")
    }
}