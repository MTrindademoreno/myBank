package com.marciotrindade.mybank.api.model

data class Result(
    val error: Error,
    val userAccount: UserAccount
)