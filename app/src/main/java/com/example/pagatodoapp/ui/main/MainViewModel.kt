package com.example.pagatodoapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pagatodoapp.model.Transaction
import com.example.pagatodoapp.repository.TransactionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    transactionRepository: TransactionRepository
) : ViewModel() {
    private val transactionsLiveData = MutableLiveData<List<Transaction>>()
    val transactions: LiveData<List<Transaction>> = transactionsLiveData

    init {
        viewModelScope.launch() {
            val result = transactionRepository.getValidResponse()
            transactionsLiveData.value = result.data?.transactions
        }
    }
}