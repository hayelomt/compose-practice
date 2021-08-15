package com.example.composeapplication.src.todo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.src.todo.TodoItem

@Composable
fun TodoEntry(
    todoItem: TodoItem,
    isEditing: Boolean,
    onItemClicked: (TodoItem) -> Unit,
    onEditDone: (TodoItem) -> Unit,
    onRemove: (TodoItem) -> Unit
) {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(todoItem) }) {
            TodoRow(todoText = todoItem.todo)
        }
        if (isEditing) {
            val (text, setText) = remember { mutableStateOf(todoItem.todo) }

            TodoInput(text = text, onTextChange = setText) {
                Row {
                    IconButton(onClick = { onEditDone(TodoItem(id = todoItem.id, todo = text)) }) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Edit",
                            tint = Color.Green
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(onClick = { onRemove(todoItem) }) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Remove",
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoEntry() {
    TodoEntry(
        todoItem = TodoItem(todo = "Fix Room"),
        isEditing = false,
        onItemClicked = {},
        onEditDone = {},
        onRemove = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoEntryEditing() {
    TodoEntry(
        todoItem = TodoItem(todo = "Eat"),
        isEditing = true,
        onItemClicked = {},
        onEditDone = {},
        onRemove = {}
    )
}