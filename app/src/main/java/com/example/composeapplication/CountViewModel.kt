package com.example.composeapplication

import android.util.Log
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {
    init {
        Log.d("VIEW_MODEL", "INIT VM")
    }

    fun getCount(): Int {
        return 10
    }
}