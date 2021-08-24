package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    private val rdManager: RDManager by lazy { RDManager() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeApplicationTheme {
                AddData {
                    rdManager.addDummyData()
                }
            }
        }
    }
}

@Composable
fun AddData(addData: () -> Unit) {
    Button(onClick = addData) {
        Text(text = "Add Data")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    ComposeApplicationTheme {
        Text("Hello World")
    }
}

