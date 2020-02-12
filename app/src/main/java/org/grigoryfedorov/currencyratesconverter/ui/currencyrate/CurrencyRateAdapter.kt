package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import org.grigoryfedorov.currencyratesconverter.R

class CurrencyRateAdapter(
    diffCallback: DiffUtil.ItemCallback<CurrencyItemUiState>,
    private val listener: Listener
) : ListAdapter<CurrencyItemUiState, CurrencyRateViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyRateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_rate_item, parent, false)
        return CurrencyRateViewHolder(itemView, listener)
    }

    override fun onBindViewHolder(holder: CurrencyRateViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface Listener {
        fun onItemClick(id: String, value: String)
        fun onInput(id: String, value: String)
    }
}
