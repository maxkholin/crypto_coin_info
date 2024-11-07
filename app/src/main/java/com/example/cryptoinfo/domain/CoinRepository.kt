package com.example.cryptoinfo.domain

import androidx.lifecycle.LiveData

interface CoinRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinDetailedInfo(fromSymbol: String): LiveData<CoinInfo>

    suspend fun loadData()
}