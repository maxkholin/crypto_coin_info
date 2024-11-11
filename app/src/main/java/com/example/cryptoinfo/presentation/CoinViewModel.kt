package com.example.cryptoinfo.presentation

import androidx.lifecycle.ViewModel
import com.example.cryptoinfo.domain.GetCoinDetailedInfoUseCase
import com.example.cryptoinfo.domain.GetCoinInfoListUseCase
import com.example.cryptoinfo.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val getCoinDetailedInfoUseCase: GetCoinDetailedInfoUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinDetailedInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}