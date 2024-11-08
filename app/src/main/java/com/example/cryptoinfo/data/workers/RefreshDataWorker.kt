package com.example.cryptoinfo.data.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkerParameters
import com.example.cryptoinfo.data.database.AppDatabase
import com.example.cryptoinfo.data.mapper.CoinMapper
import com.example.cryptoinfo.data.network.ApiFactory
import kotlinx.coroutines.delay

class RefreshDataWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val coinInfoDao = AppDatabase.getInstance(context).coinPriceInfoDao()
    private val mapper = CoinMapper()
    private val apiService = ApiFactory.apiService

    override suspend fun doWork(): Result {
        while (true) {
            try {
                val topCoins = apiService.getTopCoinsInfo(limit = 20)
                val fromSymbols = mapper.mapNamesListToString(topCoins)
                val jsonContainer = apiService.getFullPriceList(fSyms = fromSymbols)
                val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
                val dbModelList = coinInfoDtoList.map { mapper.mapDtoToDbModel(it) }
                coinInfoDao.insertPriceList(dbModelList)
            } catch (e: Exception) {
            }

            delay(10_000)
        }
    }

    companion object{

        const val WORKER_NAME = "RefreshDataWorker"

        fun makeRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<RefreshDataWorker>().build()
        }
    }
}