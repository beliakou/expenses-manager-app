package com.github.beliakou.expenses.server.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.io.Resource
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean

@Configuration
@Profile("prod")
@EnableMongoRepositories("com.github.beliakou.expenses.server.repository")
open class MongoConfig : AbstractMongoClientConfiguration() {

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
        return "prod"
    }

}

@Configuration
@Profile("dev")
@EnableMongoRepositories("com.github.beliakou.expenses.server.repository")
open class MongoTestConfig : AbstractMongoClientConfiguration() {

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

    @Bean
    @Autowired
    open fun repositoryPopulator(@Value("classpath:data.json") testData: Resource, objectMapper: ObjectMapper): Jackson2RepositoryPopulatorFactoryBean {
        val factory = Jackson2RepositoryPopulatorFactoryBean()
        factory.setMapper(objectMapper)
        factory.setResources(arrayOf(testData))
        return factory
    }

}