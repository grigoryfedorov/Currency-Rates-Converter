package org.grigoryfedorov.currencyratesconverter.data

import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyRatesService {

    @GET("latest")
    suspend fun getLatestCurrencyRates(@Query("base") base: String): ApiCurrencyRates
}
