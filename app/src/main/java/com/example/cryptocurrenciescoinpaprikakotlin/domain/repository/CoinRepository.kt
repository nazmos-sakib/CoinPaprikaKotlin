package com.example.cryptocurrenciescoinpaprikakotlin.domain.repository

import com.example.cryptocurrenciescoinpaprikakotlin.data.remote.dto.CoinDetailDto
import com.example.cryptocurrenciescoinpaprikakotlin.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}