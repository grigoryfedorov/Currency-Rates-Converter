package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import androidx.recyclerview.widget.DiffUtil

class CurrencyRateDiffUtilCallback : DiffUtil.ItemCallback<CurrencyItemUiState>() {
    override fun areItemsTheSame(oldItem: CurrencyItemUiState, newItem: CurrencyItemUiState): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CurrencyItemUiState, newItem: CurrencyItemUiState): Boolean {
        return oldItem == newItem
    }
}
