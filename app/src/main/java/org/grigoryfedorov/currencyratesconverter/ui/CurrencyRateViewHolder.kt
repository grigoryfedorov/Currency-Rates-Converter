package org.grigoryfedorov.currencyratesconverter.ui

import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.grigoryfedorov.currencyratesconverter.R
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate

class CurrencyRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val rate: EditText = itemView.findViewById(R.id.currency_rate_item_rate)
    private val title: TextView = itemView.findViewById(R.id.currency_rate_item_title)
    private val description: TextView = itemView.findViewById(R.id.currency_rate_item_description)
    val icon: ImageView = itemView.findViewById(R.id.currency_rate_item_icon)

    fun bind(item: CurrencyRate) {
        title.text = item.currencyShortName
        description.text = item.currencyLongName
        rate.setText("${item.rate}")
    }

}
