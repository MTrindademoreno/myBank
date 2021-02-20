package com.marciotrindade.mybank.api.model

data class UserAccountX(
    val agency: String,
    val balance: Double,
    val bankAccount: String,
    val name: String,
    val userId: Int
)