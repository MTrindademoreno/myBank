package com.marciotrindade.mybank.api.model

import java.math.BigDecimal
import java.util.*

data class Statement(
    val date: Date,
    val desc: String,
    val title: String,
    val value: BigDecimal
)