package com.example.composeapplication.src.todo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
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
    onEditTextChange: (String) -> Unit,
    onEditDone: () -> Unit,
    onRemove: (TodoItem) -> Unit
) {
    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(todoItem) }) {
            TodoRow(todoText = todoItem.todo)
        }
        if (isEditing) {
            TodoInput(text = todoItem.todo, onTextChange = onEditTextChange) {
                Row {
                    IconButton(onClick = onEditDone) {
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
        todoItem = TodoItem("Fix Room"),
        isEditing = false,
        onItemClicked = {},
        onEditTextChange = {},
        onEditDone = {},
        onRemove = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoEntryEditing() {
    TodoEntry(
        todoItem = TodoItem("Eat"),
        isEditing = true,
        onItemClicked = {},
        onEditTextChange = {},
        onEditDone = {},
        onRemove = {}
    )
}