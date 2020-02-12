package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.grigoryfedorov.currencyratesconverter.interactor.CurrencyRatesInteractor
import java.text.DecimalFormat

class CurrencyRateViewModel(
    private val currencyRatesInteractor: CurrencyRatesInteractor
) : ViewModel() {

    companion object {
        const val DEFAULT_CURRENCY_ID = "EUR"
        const val DEFAULT_AMOUNT = 1.0
    }

    val currencyRates: LiveData<List<CurrencyItemUiState>>
        get() = _currencyRates
    private val _currencyRates = MutableLiveData<List<CurrencyItemUiState>>()

    fun onStart() {
        update(DEFAULT_CURRENCY_ID, DEFAULT_AMOUNT)
    }

    fun onCurrencyRateItemClick(currencyId: String, value: String) {
        update(currencyId, value.toDouble())
    }

    fun onCurrencyValueInput(id: String, value: String) {
        update(id, value.toDouble())
    }

    private fun update(currencyId: String, amount: Double) {
        val format = DecimalFormat("0.##")

        viewModelScope.launch {
            val currencyRates = currencyRatesInteractor.getCurrencyRates(currencyId)
            _currencyRates.value = listOf(
                CurrencyItemUiState(
                    id = currencyId,
                    title = currencyId,
                    description = "",
                    icon = "",
                    value = format.format(amount),
                    isActive = true
                )
            ) + currencyRates.listRates.map {
                CurrencyItemUiState(
                    id = it.id,
                    title = it.id,
                    description = "",
                    icon = "",
                    value = format.format(amount * it.rate),
                    isActive = false
                )
            }
        }
    }

}
