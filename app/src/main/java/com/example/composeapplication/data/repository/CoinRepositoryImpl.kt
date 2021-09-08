package com.example.composeapplication.data.repository

import com.example.composeapplication.data.remote.CoinPaprikaApi
import com.example.composeapplication.data.remote.dto.CoinDetailDto
import com.example.composeapplication.data.remote.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }

}