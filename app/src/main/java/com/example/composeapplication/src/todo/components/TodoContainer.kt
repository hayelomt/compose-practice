package com.example.composeapplication.src.todo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapplication.src.todo.TodoItem

@Composable
fun TodoContainer(
    todoList: List<TodoItem>,
    currentlyEditing: TodoItem?,
    onAddItem: (TodoItem) -> Unit,
    onItemClicked: (TodoItem) -> Unit,
    onEditDone: (TodoItem) -> Unit,
    onRemove: (TodoItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val isEditing = currentlyEditing != null

    Column(modifier = modifier.fillMaxSize()) {
        TodoScreenHeader(isEditing = isEditing, onAddItem = onAddItem)

        LazyColumn(contentPadding = PaddingValues(4.dp)) {
            items(items = todoList) { item ->
                TodoEntry(
                    todoItem = item,
                    isEditing = if (isEditing) currentlyEditing?.id == item.id else false,
                    onItemClicked = onItemClicked,
                    onEditDone = onEditDone,
                    onRemove = onRemove
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoScreenEditing() {
    val item1 = TodoItem(todo = "Fix Home")
    TodoContainer(
        todoList = listOf(
            item1,
            TodoItem( todo = "Take Shower"),
            TodoItem( todo = "Eat Lunch"),
            TodoItem( todo = "Code ViewModel"),
        ),
        currentlyEditing = item1,
        onAddItem = {},
        onItemClicked = {},
        onEditDone = {},
        onRemove = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTodoScreen() {
    TodoContainer(
        todoList = listOf(
            TodoItem( todo = "Fix Home"),
            TodoItem( todo = "Take Shower"),
            TodoItem( todo = "Eat Lunch"),
            TodoItem( todo = "Code ViewModel"),
        ),
        currentlyEditing = null,
        onAddItem = {},
        onItemClicked = {},
        onEditDone = {},
        onRemove = {}
    )
}
