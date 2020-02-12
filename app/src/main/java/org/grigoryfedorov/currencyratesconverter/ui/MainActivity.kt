package org.grigoryfedorov.currencyratesconverter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.grigoryfedorov.currencyratesconverter.R
import org.grigoryfedorov.currencyratesconverter.ui.currencyrate.CurrencyRateFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CurrencyRateFragment.newInstance())
                .commit()
        }
    }
}
