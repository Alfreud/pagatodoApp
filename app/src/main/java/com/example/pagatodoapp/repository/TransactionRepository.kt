package com.example.pagatodoapp.repository

import android.util.Log
import com.example.pagatodoapp.data.remote.TransactionRemoteDataSource
import com.example.pagatodoapp.data.remote.TransactionService
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    private val transactionRemoteDataSource: TransactionRemoteDataSource
) {

    suspend fun getValidResponse() = transactionRemoteDataSource.getValidResponse()

    suspend fun getEmptyResponse() = transactionRemoteDataSource.getEmptyResponse()

    suspend fun getMalformedResponse() = transactionRemoteDataSource.getMalformedResponse()
}