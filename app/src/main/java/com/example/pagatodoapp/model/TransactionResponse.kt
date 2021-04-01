package com.example.pagatodoapp.model

import com.google.gson.annotations.SerializedName

data class TransactionResponse(
    @SerializedName("servicioPrueba") val transactions: List<Transaction>
)