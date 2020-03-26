package com.github.beliakou.expenses.server.repository

import com.github.beliakou.expenses.server.model.Category
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
interface CategoryRepository : MongoRepository<Category, String> {

}