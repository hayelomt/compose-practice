package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Text("Hello Compose")
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeApplicationTheme {
        Surface(color = Color.LightGray) {
            content()
        }
    }
}

@Preview
@Composable
fun PreviewMessageCard() {
    MyApp {
        Text("Hello Compose")
    }
}

