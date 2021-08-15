package com.example.composeapplication.src.todo.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.src.todo.TodoItem

@Composable
fun TodoEntryInput(onAddItem: (TodoItem) -> Unit) {
    val (text, setText) = remember { mutableStateOf("") }

    TodoInput(text = text, onTextChange = setText) {
        Button(onClick = { onAddItem(TodoItem(text)) }) {
            Text(text = "Add Item")
        }
    }
}

@Composable
fun TodoScreenHeader(
    isEditing: Boolean,
    onAddItem: (TodoItem) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        if (isEditing) {
            Text(
                text ="Editing Item",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        } else {
            TodoEntryInput(onAddItem = onAddItem)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoHeaderEditing() {
    TodoScreenHeader(isEditing = true, onAddItem = {})
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoHeaderInput() {
    TodoScreenHeader(isEditing = false, onAddItem = {})
}