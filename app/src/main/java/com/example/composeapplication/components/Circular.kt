package com.example.composeapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*

@Composable
fun Circular() {
    val itemsCount = 6;

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

    }
    Card()
}

@Composable
fun Card() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color(red = 0.925f, green = 0.176f, blue = 0.176f, alpha = 1.0f))
    ) {}
}

@Preview(showBackground = true)
@Composable
fun PreviewCircular() {
    Box(modifier = Modifier.fillMaxSize()) {
        Circular()
    }
}