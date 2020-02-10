package org.grigoryfedorov.currencyratesconverter.ui

import androidx.recyclerview.widget.DiffUtil
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate

class CurrencyRateDiffUtilCallback : DiffUtil.ItemCallback<CurrencyRate>() {
    override fun areItemsTheSame(oldItem: CurrencyRate, newItem: CurrencyRate): Boolean {
        return oldItem.currencyShortName == newItem.currencyShortName
    }

    override fun areContentsTheSame(oldItem: CurrencyRate, newItem: CurrencyRate): Boolean {
        return oldItem == newItem
    }
}
