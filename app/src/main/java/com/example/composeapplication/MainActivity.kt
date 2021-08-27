package com.example.composeapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class MainActivity : ComponentActivity() {
    @InternalCoroutinesApi
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            ComposeApplicationTheme {
//                Text("Hello World")
//            }
//        }

        val countFlow = flow {
            for (i in 1..10) {
                delay(1000L)
                emit("Itm $i")
            }
        }
        

        GlobalScope.launch {
            countFlow.collect {
                Log.d("FLOWER", it)
            }
//            countFlow.collect {
//                Log.d("FLOWER", it)
//            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewMessageCard() {
//    ComposeApplicationTheme {
//        Text("Hello World")
//    }
//}
//
