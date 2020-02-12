package org.grigoryfedorov.currencyratesconverter.ui.currencyrate

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.grigoryfedorov.currencyratesconverter.R

class CurrencyRateViewHolder(
    itemView: View,
    private val listener: CurrencyRateAdapter.Listener
) : RecyclerView.ViewHolder(itemView) {

    private val value: EditText = itemView.findViewById(R.id.currency_rate_item_rate)
    private val title: TextView = itemView.findViewById(R.id.currency_rate_item_title)
    private val description: TextView = itemView.findViewById(R.id.currency_rate_item_description)
    val icon: ImageView = itemView.findViewById(R.id.currency_rate_item_icon)
    private var valueTextWatcher: ValueTextWatcher? = null

    fun bind(item: CurrencyItemUiState) {
        title.text = item.title
        description.text = item.description
        value.setText(item.value)
        itemView.setOnClickListener {
            listener.onItemClick(item.id, value.text.toString())
        }
        if (item.isActive) {
            valueTextWatcher = ValueTextWatcher(item)
            value.addTextChangedListener(valueTextWatcher)
        } else {
            valueTextWatcher?.let {
                value.removeTextChangedListener(it)
            }
        }
    }

    inner class ValueTextWatcher(private val item: CurrencyItemUiState) : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            p0?.let {
                listener.onInput(item.id, p0.toString())
            }
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

}
