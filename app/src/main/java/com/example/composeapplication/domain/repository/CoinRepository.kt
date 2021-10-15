package com.example.composeapplication.domain.repository

import com.example.composeapplication.data.remote.dto.CoinDetailDto
import com.example.composeapplication.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}