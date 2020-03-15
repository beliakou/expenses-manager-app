package com.github.beliakou.expenses.server.controller

import com.fasterxml.jackson.annotation.JsonView
import com.github.beliakou.expenses.server.model.User
import com.github.beliakou.expenses.server.util.View
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(@Autowired val mongoTemplate: MongoTemplate) {

    @GetMapping("/user")
    @JsonView(View.Public::class)
    fun user(@RequestParam(value = "name") name: String): User? {
        return this.mongoTemplate.findOne(
                Query.query(Criteria.where("name").`is`(name)), User::class.java, "user")
    }
}