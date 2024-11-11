package com.example.cryptoinfo.di

import android.app.Application
import com.example.cryptoinfo.presentation.CoinDetailActivity
import com.example.cryptoinfo.presentation.CoinDetailFragment
import com.example.cryptoinfo.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}