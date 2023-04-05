package com.example.cryptocurrenciescoinpaprikakotlin.domain.use_case.get_coins

import com.example.cryptocurrenciescoinpaprikakotlin.common.Resource
import com.example.cryptocurrenciescoinpaprikakotlin.data.remote.dto.toCoin
import com.example.cryptocurrenciescoinpaprikakotlin.data.repository.CoinRepositoryImpl
import com.example.cryptocurrenciescoinpaprikakotlin.domain.model.Coin
import com.example.cryptocurrenciescoinpaprikakotlin.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }
}