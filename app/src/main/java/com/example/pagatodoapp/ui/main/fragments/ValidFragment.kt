package com.example.pagatodoapp.ui.main.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagatodoapp.R
import com.example.pagatodoapp.ui.main.MainViewModel
import com.example.pagatodoapp.ui.main.TransactionAdapter
import com.example.pagatodoapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_valid.*

@AndroidEntryPoint
class ValidFragment : Fragment(R.layout.fragment_valid) {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val transactionAdapter =
            TransactionAdapter()
        recyclerView.apply {
            adapter = transactionAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.validTransactions.observe(viewLifecycleOwner, Observer { transactionsResponse ->
            when (transactionsResponse.status) {
                Resource.Status.SUCCESS -> {
                    transactionAdapter.submitList(transactionsResponse.data?.transactions)
                }

                Resource.Status.ERROR -> {
                    //Toast.makeText(context, transactionsResponse.message, Toast.LENGTH_LONG).show()
                    tvError.visibility = View.VISIBLE
                    tvError.text = transactionsResponse.message
                }

                Resource.Status.LOADING -> {
                    indeterminateProgressbar.visibility = View.VISIBLE
                }
            }
        })
    }
}