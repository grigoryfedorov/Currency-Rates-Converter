package org.grigoryfedorov.currencyratesconverter.data

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class ApiCurrencyRates(
    @SerializedName("base")
    val base: String,
    @SerializedName("data")
    val data: String,
    @SerializedName("rates")
    val rates: JsonObject
)
