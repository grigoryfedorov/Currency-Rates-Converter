package org.grigoryfedorov.currencyratesconverter.data

import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRates

interface CurrencyRatesRepository {
    suspend fun getCurrencyRates(): CurrencyRates
}
