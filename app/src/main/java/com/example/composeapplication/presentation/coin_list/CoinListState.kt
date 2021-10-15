package com.example.composeapplication.presentation.coin_list

import com.example.composeapplication.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
