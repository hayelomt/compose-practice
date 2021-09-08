package com.example.composeapplication.presentation.coindetail

import com.example.composeapplication.domain.model.CoinDetail

data class CoinDetailState (
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = "",
) {
}