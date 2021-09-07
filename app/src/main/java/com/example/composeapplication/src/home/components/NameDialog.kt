package com.example.composeapplication.src.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NameDialog(
    onConfirm: (String) -> Unit,
    onDismiss: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    val isInValid = username.length < 3 || username.length > 6

    AlertDialog(
        title = {
            Text(text = "Enter username")
        },
        text = {
           Column {

               OutlinedTextField(
                   value = username,
                   label = { Text("Username") },
                   onValueChange = {
                       username = it
                   },
                   placeholder = { Text("Enter username(3-6 characters)")},
                   isError = isInValid
               )
               if (isInValid) {
                   Text(
                       textAlign = TextAlign.Start,
                       text = "Username must be between 3-6 characters",
                       style = MaterialTheme.typography.caption.copy(color = Color.Red),
                   )
               }
           }
        },
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = { onConfirm(username) }, enabled = !isInValid) {
                Text("Start")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewNameDialog() {
    NameDialog(
        onConfirm = {},
        onDismiss = {}
    )
}