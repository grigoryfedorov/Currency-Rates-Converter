package org.grigoryfedorov.currencyratesconverter.data

import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRates

class CurrencyRatesRepositoryImpl(
    private val currencyRatesDataSource: CurrencyRatesDataSource
) : CurrencyRatesRepository {
    override suspend fun getCurrencyRates(currencyId: String): CurrencyRates {
        return currencyRatesDataSource.getCurrencyRates(currencyId)
    }

}
