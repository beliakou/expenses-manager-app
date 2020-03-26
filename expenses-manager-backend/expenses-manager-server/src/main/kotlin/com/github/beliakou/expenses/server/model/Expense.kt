package com.github.beliakou.expenses.server.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDate

@Document
data class Expense(@Id val id: String?,
                   val userId: String,
                   val date: LocalDate,
                   val category: String,
                   val amount: BigDecimal)