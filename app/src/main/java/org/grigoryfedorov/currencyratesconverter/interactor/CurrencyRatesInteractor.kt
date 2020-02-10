package org.grigoryfedorov.currencyratesconverter.interactor

import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRates

interface CurrencyRatesInteractor {
    suspend fun getCurrencyRates(): CurrencyRates
}
