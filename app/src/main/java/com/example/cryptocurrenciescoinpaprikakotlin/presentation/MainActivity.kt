package com.example.cryptocurrenciescoinpaprikakotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrenciescoinpaprikakotlin.R
import com.example.cryptocurrenciescoinpaprikakotlin.presentation.coin_details.CoinDetailScreen
import com.example.cryptocurrenciescoinpaprikakotlin.presentation.coin_list.CoinListScreen
import com.example.cryptocurrenciescoinpaprikakotlin .presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent {
            CryptocurrencyAppYTTheme {

                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}