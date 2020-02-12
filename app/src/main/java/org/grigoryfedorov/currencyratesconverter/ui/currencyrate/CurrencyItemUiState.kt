package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

data class CurrencyItemUiState(
    val id: String,
    val title: String,
    val description: String,
    val icon: String,
    val value: String,
    val isActive: Boolean
)
