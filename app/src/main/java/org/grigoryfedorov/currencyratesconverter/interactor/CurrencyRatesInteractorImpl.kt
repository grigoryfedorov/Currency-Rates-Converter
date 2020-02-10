package org.grigoryfedorov.currencyratesconverter.interactor

import org.grigoryfedorov.currencyratesconverter.data.CurrencyRatesRepository
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRates

class CurrencyRatesInteractorImpl(
    private val currencyRatesRepository: CurrencyRatesRepository
) : CurrencyRatesInteractor {
    override suspend fun getCurrencyRates(): CurrencyRates {
        return currencyRatesRepository.getCurrencyRates()
    }
}
