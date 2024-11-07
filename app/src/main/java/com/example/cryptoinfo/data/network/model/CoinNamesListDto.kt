package com.example.cryptoinfo.data.network.model

import com.example.cryptoinfo.data.network.model.CoinNameContainerDto
import com.google.gson.annotations.SerializedName

data class CoinNamesListDto (
    @SerializedName("Data")
    val names: List<CoinNameContainerDto>? = null
)
