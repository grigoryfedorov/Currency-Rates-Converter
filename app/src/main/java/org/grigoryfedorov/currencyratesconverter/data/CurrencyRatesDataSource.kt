package org.grigoryfedorov.currencyratesconverter.data

import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRates

class CurrencyRatesDataSource(private val currencyRatesService: CurrencyRatesService) {
    suspend fun getCurrencyRates(currencyId: String): CurrencyRates {
        val apiCurrencyRates = currencyRatesService.getLatestCurrencyRates(currencyId)

            val rates: List<CurrencyRate> = apiCurrencyRates.rates.keySet().map {
            CurrencyRate(
                id = it,
                description = "",
                rate = apiCurrencyRates.rates.get(it).asDouble,
                icon = ""
            )
        }

        return CurrencyRates(
            apiCurrencyRates.base,
            rates
        )
    }
}
