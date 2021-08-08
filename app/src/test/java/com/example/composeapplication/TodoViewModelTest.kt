package com.example.composeapplication

import com.example.composeapplication.todo.TodoViewModel
import com.example.composeapplication.util.generateRandomTodoItem
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class TodoViewModelTest {
    @Test
    fun whenRemovingItem_updatesList() {
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        val item2 = generateRandomTodoItem()
        viewModel.addItem(item1)
        viewModel.addItem(item2)

        viewModel.removeItem(item1)

        assertThat("add", true)
        assertThat("Only Item 2", viewModel.todoItems.first().task == item2.task)
    }
}