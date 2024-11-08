package com.example.cryptoinfo.domain

import androidx.lifecycle.LiveData

class GetCoinDetailedInfoUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(fromSymbol: String): LiveData<CoinInfo> {
        return repository.getCoinDetailedInfo(fromSymbol)
    }
}