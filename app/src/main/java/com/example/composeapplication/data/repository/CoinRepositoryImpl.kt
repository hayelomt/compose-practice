package com.example.composeapplication.data.repository

import android.util.Log
import com.example.composeapplication.data.remote.CoinPaprikaApi
import com.example.composeapplication.data.remote.dto.CoinDetailDto
import com.example.composeapplication.data.remote.dto.CoinDto
import com.example.composeapplication.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
//        Log.d("CRYPTOAPP", "GET COIN $coinId")
        return api.getCoinById(coinId)
    }
}