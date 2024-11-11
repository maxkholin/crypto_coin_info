package com.example.cryptoinfo.di

import android.app.Application
import com.example.cryptoinfo.data.database.AppDatabase
import com.example.cryptoinfo.data.database.CoinInfoDao
import com.example.cryptoinfo.data.repository.CoinRepositoryImpl
import com.example.cryptoinfo.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

    }
}