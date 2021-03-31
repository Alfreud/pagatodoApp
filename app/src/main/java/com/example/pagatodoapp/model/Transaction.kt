package com.example.pagatodoapp.model

import java.sql.Timestamp

data class Transaction(
        var uuid: String,
        var merchantUuid: String,
        var merchantName: String,
        var currencyCode: String,
        var amount: Int,
        var timestamp: String
)