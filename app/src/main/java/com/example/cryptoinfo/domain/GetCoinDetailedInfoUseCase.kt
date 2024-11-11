package com.example.cryptoinfo.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetCoinDetailedInfoUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(fromSymbol: String): LiveData<CoinInfo> {
        return repository.getCoinDetailedInfo(fromSymbol)
    }
}