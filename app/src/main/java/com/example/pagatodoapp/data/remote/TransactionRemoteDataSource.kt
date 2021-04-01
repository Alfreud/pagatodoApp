package com.example.pagatodoapp.data.remote

import javax.inject.Inject

class TransactionRemoteDataSource @Inject constructor(
    private val transactionService: TransactionService
) : BaseDataSource() {

    suspend fun getValidResponse() = getResult { transactionService.getValidResponse() }

    suspend fun getEmptyResponse() = getResult { transactionService.getEmptyResponse() }

    suspend fun getMalformedResponse() = getResult { transactionService.getMalformedResponse() }
}