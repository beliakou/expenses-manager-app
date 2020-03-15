package com.github.beliakou.expenses.server.integration

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean

@Configuration
open class TestConfig {

    @Bean
    @Autowired
    open fun repositoryPopulator(@Value("classpath:test-data.json") testData: Resource, objectMapper: ObjectMapper): Jackson2RepositoryPopulatorFactoryBean {
        val factory = Jackson2RepositoryPopulatorFactoryBean()
        factory.setMapper(objectMapper)
        factory.setResources(arrayOf(testData))
        return factory
    }
}