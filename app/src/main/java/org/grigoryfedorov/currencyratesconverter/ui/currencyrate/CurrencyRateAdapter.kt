package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import org.grigoryfedorov.currencyratesconverter.R
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate

class CurrencyRateAdapter(
    diffCallback: DiffUtil.ItemCallback<CurrencyRate>
) : ListAdapter<CurrencyRate, CurrencyRateViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyRateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_rate_item, parent, false)
        return CurrencyRateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrencyRateViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
