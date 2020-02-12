package org.grigoryfedorov.currencyratesconverter.domain

data class CurrencyRate(
    val id: String,
    val description: String,
    val rate: Double,
    val icon: String
)
