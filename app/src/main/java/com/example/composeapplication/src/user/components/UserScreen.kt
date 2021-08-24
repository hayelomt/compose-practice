package com.example.composeapplication.src.user.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapplication.src.user.UserViewModel

@Composable
fun UserScreen(userViewModel: UserViewModel) {
    Column {
        Text("User Screen")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = userViewModel::getUser) {
            Text(text = "Get User")
        }
    }
}