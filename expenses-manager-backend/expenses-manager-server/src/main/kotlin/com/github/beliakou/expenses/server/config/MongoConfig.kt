package com.github.beliakou.expenses.server.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration

@Configuration
open class MongoConfig: AbstractMongoClientConfiguration() {

    @Value("\${mongo.url}")
    lateinit var mongoUrl: String

    override fun mongoClient(): MongoClient {
        val settings = MongoClientSettings.builder()
                .applyConnectionString(ConnectionString(mongoUrl))
                .retryWrites(true)
                .build()

        return MongoClients.create(settings)
    }

    override fun getDatabaseName(): String {
        return "test"
    }

}