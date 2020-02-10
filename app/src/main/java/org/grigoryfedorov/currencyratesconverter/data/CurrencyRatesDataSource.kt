package org.grigoryfedorov.currencyratesconverter.data

import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRates

class CurrencyRatesDataSource(private val currencyRatesService: CurrencyRatesService) {
    suspend fun getCurrencyRates(): CurrencyRates {
        val apiCurrencyRates = currencyRatesService.getLatestCurrencyRates("EUR")

            val rates: List<CurrencyRate> = apiCurrencyRates.rates.keySet().map {
            CurrencyRate(
                currencyShortName = it,
                currencyLongName = "",
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
