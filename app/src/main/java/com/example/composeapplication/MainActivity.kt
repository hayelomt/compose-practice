package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                CardScreen()
            }
        }
    }
}

@Composable
fun Animated() {
    var sizeState by remember { mutableStateOf(100.dp)}
    val size by animateDpAsState(targetValue = sizeState)

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { sizeState += 50.dp }) {
            Text("Inc Size")
        }
    }
}

@Composable
fun CardScreen() {
    Animated()
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    ComposeApplicationTheme {
        CardScreen()
    }
}

