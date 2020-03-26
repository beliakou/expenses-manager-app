package com.github.beliakou.expenses.server.repository

import com.github.beliakou.expenses.server.model.Expense
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

@RepositoryRestResource(collectionResourceRel = "expenses", path = "expenses")
interface ExpenseRepository : MongoRepository<Expense, String> {

    fun findAllByUserIdIgnoreCase(userId: String): MutableCollection<Expense>

    @Query(value = "{'\$and': [{'userId' : ?0}, { 'date': { '\$gte': ?1 , '\$lt': ?2 } }] }", sort = "{ 'date': 1 }")
    fun findAllByDateBetween(userId: String,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") from: LocalDate,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") to: LocalDate): MutableCollection<Expense>

}