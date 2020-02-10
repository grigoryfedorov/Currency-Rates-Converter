package org.grigoryfedorov.currencyratesconverter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import org.grigoryfedorov.currencyratesconverter.R
import org.grigoryfedorov.currencyratesconverter.domain.CurrencyRate

class CurrencyRateFragment : Fragment() {

    companion object {
        fun newInstance() = CurrencyRateFragment()
    }

    private lateinit var viewModel: CurrencyRateViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var currencyRateAdapter: CurrencyRateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.currency_rate_fragment, container, false)
        recyclerView = view.findViewById(R.id.currency_rate_recycler_view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        currencyRateAdapter = CurrencyRateAdapter(CurrencyRateDiffUtilCallback())
        recyclerView.adapter = currencyRateAdapter

        viewModel = ViewModelProvider(this, CurrencyRateViewModelFactory())
            .get(CurrencyRateViewModel::class.java)

        viewModel.currencyRates.observe(viewLifecycleOwner, Observer<List<CurrencyRate>> {
            currencyRateAdapter.submitList(it)
        })
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }
}
