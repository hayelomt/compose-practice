package com.example.composeapplication.src.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeContainer() {
    var showNameDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { showNameDialog = true }) {
            Text(text = "Start Game")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Join Game")
        }
    }

    if (showNameDialog) {
        NameDialog(onConfirm = {}, onDismiss = { showNameDialog = false })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeContainer() {
    HomeContainer()
}