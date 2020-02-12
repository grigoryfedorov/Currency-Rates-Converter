package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate
import org.grigoryfedorov.currencyratesconverter.interactor.CurrencyRatesInteractor

class CurrencyRateViewModel(
    private val currencyRatesInteractor: CurrencyRatesInteractor
) : ViewModel() {

    val currencyRates: LiveData<List<CurrencyRate>>
        get() = _currencyRates
    private val _currencyRates = MutableLiveData<List<CurrencyRate>>()

    fun onStart() {
        viewModelScope.launch {
            val currencyRates = currencyRatesInteractor.getCurrencyRates()
            _currencyRates.value = currencyRates.listRates
            Log.i("CurrencyRateViewModel", "currency rates $currencyRates")
        }
    }
}
