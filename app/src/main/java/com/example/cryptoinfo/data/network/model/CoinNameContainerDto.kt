package com.example.cryptoinfo.data.network.model

import com.google.gson.annotations.SerializedName

data class CoinNameContainerDto (
    @SerializedName("CoinInfo")
    val coinName: CoinNameDto? = null
)
