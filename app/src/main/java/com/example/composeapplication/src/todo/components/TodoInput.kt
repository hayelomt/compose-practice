package com.example.composeapplication.src.todo.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TodoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},
    buttonSlot: @Composable () -> Unit = {}
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f).padding(end = 8.dp).align(Alignment.Bottom),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onImeAction()
                    keyboardController?.hide()
                }
            ),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Box(modifier = Modifier.align(Alignment.CenterVertically)) { buttonSlot() }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoTextInput() {
    TodoInput("SOme Input", {}) { Text("Input Button", modifier = Modifier) }
}