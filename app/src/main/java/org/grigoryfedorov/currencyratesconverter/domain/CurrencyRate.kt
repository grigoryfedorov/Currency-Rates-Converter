package org.grigoryfedorov.currencyratesconverter.domain

data class CurrencyRate(
    val currencyShortName: String,
    val currencyLongName: String,
    val rate: Double,
    val icon: String
)
