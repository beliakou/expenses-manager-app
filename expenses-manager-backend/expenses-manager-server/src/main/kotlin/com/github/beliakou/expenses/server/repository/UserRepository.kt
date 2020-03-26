package com.github.beliakou.expenses.server.repository

import com.github.beliakou.expenses.server.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
interface UserRepository : MongoRepository<User, String> {

    fun findByName(name: String): User
}