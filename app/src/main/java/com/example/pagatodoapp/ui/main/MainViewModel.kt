package com.example.pagatodoapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pagatodoapp.model.TransactionResponse
import com.example.pagatodoapp.repository.TransactionRepository
import com.example.pagatodoapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    transactionRepository: TransactionRepository
) : ViewModel() {

    private val validTransactionsLiveData = MutableLiveData<Resource<TransactionResponse>>()
    val validTransactions: LiveData<Resource<TransactionResponse>> = validTransactionsLiveData

    private val emptyTransactionsLiveData = MutableLiveData<Resource<TransactionResponse>>()
    val emptyTransactions: LiveData<Resource<TransactionResponse>> = emptyTransactionsLiveData

    private val malformedTransactionsLiveData = MutableLiveData<Resource<TransactionResponse>>()
    val malformedTransactions: LiveData<Resource<TransactionResponse>> = malformedTransactionsLiveData

    init {
        viewModelScope.launch() {
            delay(2000)
            val validResult = transactionRepository.getValidResponse()
            validTransactionsLiveData.value = validResult

            val emptyResult = transactionRepository.getEmptyResponse()
            emptyTransactionsLiveData.value = emptyResult

            val malformedResult = transactionRepository.getMalformedResponse()
            malformedTransactionsLiveData.value = malformedResult
        }

    }
}