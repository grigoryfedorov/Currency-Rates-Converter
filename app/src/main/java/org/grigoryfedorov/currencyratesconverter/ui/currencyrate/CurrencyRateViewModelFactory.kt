package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.grigoryfedorov.currencyratesconverter.data.CurrencyRatesDataSource
import org.grigoryfedorov.currencyratesconverter.data.CurrencyRatesRepositoryImpl
import org.grigoryfedorov.currencyratesconverter.data.CurrencyRatesService
import org.grigoryfedorov.currencyratesconverter.interactor.CurrencyRatesInteractorImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CurrencyRateViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CurrencyRateViewModel::class.java)) {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://revolut.duckdns.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(CurrencyRatesService::class.java)

            val currencyRatesDataSource = CurrencyRatesDataSource(service)
            val currencyRatesRepository = CurrencyRatesRepositoryImpl(currencyRatesDataSource)
            val currencyRatesInteractor = CurrencyRatesInteractorImpl(currencyRatesRepository)

            @Suppress("UNCHECKED_CAST")
            return CurrencyRateViewModel(
                currencyRatesInteractor
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
