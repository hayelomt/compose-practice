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

        val countFlow = flow<String> {
            for (i in 1..10) {
                emit("Itm $i")
                delay(1000L)
            }
        }

        GlobalScope.launch {
//            countFlow.collect {
//                Log.d("FLOWER", it)
//            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    ComposeApplicationTheme {
        Text("Hello World")
    }
}

