package com.example.cryptoinfo.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cryptoinfo.data.repository.CoinRepositoryImpl
import com.example.cryptoinfo.domain.GetCoinDetailedInfoUseCase
import com.example.cryptoinfo.domain.GetCoinInfoListUseCase
import com.example.cryptoinfo.domain.LoadDataUseCase

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinDetailedInfoUseCase = GetCoinDetailedInfoUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinDetailedInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}