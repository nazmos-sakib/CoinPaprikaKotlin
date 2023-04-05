
package com.example.cryptocurrenciescoinpaprikakotlin.presentation.coin_details

import com.example.cryptocurrenciescoinpaprikakotlin.domain.model.Coin
import com.example.cryptocurrenciescoinpaprikakotlin.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
