package com.kts.coinmarketcapwatcher.api

import com.kts.coinmarketcapwatcher.model.CoinCap
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerApi {
    @GET("ticker")
    fun loadData(@Query("limit") limit : Int = 10): Deferred<List<CoinCap>>
}