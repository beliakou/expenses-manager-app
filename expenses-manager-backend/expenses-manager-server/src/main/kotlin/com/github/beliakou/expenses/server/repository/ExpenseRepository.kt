package com.github.beliakou.expenses.server.repository

import com.github.beliakou.expenses.server.model.Expense
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "expense", path = "expenses")
interface ExpenseRepository : MongoRepository<Expense, String> {

}