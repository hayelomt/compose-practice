package com.example.composeapplication.src.app

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeapplication.RDManager
import com.example.composeapplication.shared.utils.Constants
import com.example.composeapplication.src.app.navigation.MainNavigation
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.google.firebase.database.DatabaseReference
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val rdManager: RDManager by lazy { RDManager() }
    @Inject @Named("TODO_REF")  lateinit var todoRef:  DatabaseReference;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeApplicationTheme {
//                MainNavigation()
                AddData {
                    todoRef.setValue("Hello Alan").addOnCompleteListener {
                        Log.d(Constants.TAG, "Added ref ${it.result}")
                    }.addOnFailureListener {
                        Log.d(Constants.TAG, "ERror adding ref ${it.message}")
                    }
                }
//                Text("Test World Preview")
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
        Text("Hello World Preview")
    }
}

