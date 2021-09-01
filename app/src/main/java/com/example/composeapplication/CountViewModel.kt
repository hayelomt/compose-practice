package com.example.composeapplication

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.socket.client.Socket

class CountViewModel: ViewModel() {
    var count by mutableStateOf(0)
    var mSocket: Socket = SocketHandler.getSocket()

    init {
        Log.d("SOCKET_APP", "INIT")
        mSocket.emit("get-count")
        socketListen()
    }

    private fun socketListen() {
        mSocket.on("get-count") { args ->
            count = args[0] as Int
        }
        mSocket.on("counter") { args ->
            count = args[0] as Int
        }
    }

    fun counter() {
        mSocket.emit("counter")
    }
}