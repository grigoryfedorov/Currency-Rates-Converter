package org.grigoryfedorov.currencyratesconverter.domain

data class CurrencyRates(
    val baseCurrency: String,
    val listRates: List<CurrencyRate>
)
