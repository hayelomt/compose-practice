package com.example.composeapplication

import android.util.Log
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {
    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket("http://10.0.2.2:4000")
        } catch (e: URISyntaxException) {
            Log.d("SOCKET", "Socket err $e")
        } catch (e: Exception) {
            Log.d("SOCKET", "Error $e")
        }
    }

    @Synchronized
    fun getSocket(): Socket = mSocket

    @Synchronized
    fun establishConnection() {
        mSocket.connect()
    }

    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }

}