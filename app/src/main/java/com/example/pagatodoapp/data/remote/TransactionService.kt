package com.example.pagatodoapp.data.remote

import com.example.pagatodoapp.model.TransactionResponse
import retrofit2.Response
import retrofit2.http.GET

interface TransactionService {

    @GET("pruebaFile.json")
    suspend fun getValidResponse(): Response<TransactionResponse>

    @GET("/servicioVacio.json")
    suspend fun getEmptyResponse(): Response<TransactionResponse>

    @GET("/pruebaMalFormada.json")
    suspend fun getMalformedResponse(): Response<TransactionResponse>
}