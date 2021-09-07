package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.src.game.components.CardBack
import com.example.composeapplication.src.game.components.GameBody
import com.example.composeapplication.src.home.components.HomeContainer
import com.example.composeapplication.src.home.components.NameDialog
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        SocketHandler.setSocket()
//        SocketHandler.establishConnection()

        setContent {
            ComposeApplicationTheme {
                HomeContainer()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    ComposeApplicationTheme {
        Text("Hello World")
    }
}

