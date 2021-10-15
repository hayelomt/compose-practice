package com.example.composeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.google.firebase.database.FirebaseDatabase

const val App_Tag = "MAIN_FIRE"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = FirebaseDatabase.getInstance();
        val todoRef = db.getReference("todos")

        setContent {
            ComposeApplicationTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Button(onClick = {
                        todoRef.setValue("Composer").addOnFailureListener { err ->
                            Log.d(App_Tag, "$err");
                        }.addOnSuccessListener {
                            Log.d(App_Tag, "Success")
                        }
                    }) {
                        Text("Create todo")
                    }
                }
            }
        }
    }
}
