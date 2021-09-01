package com.example.composeapplication.src.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameBody() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row() {
            Text("Head")
        }
        Column(modifier = Modifier.weight(1f).background(Color.Red)) {
            Text("Content")
        }
        Row() {
            Text(text = "Buttons")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGameBody() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        GameBody()
    }
}