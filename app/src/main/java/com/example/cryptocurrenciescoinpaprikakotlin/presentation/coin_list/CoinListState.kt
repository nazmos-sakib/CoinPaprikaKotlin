package com.example.cryptocurrenciescoinpaprikakotlin.presentation.coin_list

import com.example.cryptocurrenciescoinpaprikakotlin.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
