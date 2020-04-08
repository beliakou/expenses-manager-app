package com.github.beliakou.expenses.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Value("${mongo.url}")
    String mongoUrl;

    @Override
    public MongoClient mongoClient() {
        var settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(mongoUrl))
                .retryWrites(true)
                .build();
        return MongoClients.create(settings);
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

    @Bean
    @Profile("dev")
    Jackson2RepositoryPopulatorFactoryBean repositoryPopulatorFactoryBean(@Value("classpath:data.json") Resource testData,
                                                                          ObjectMapper objectMapper) {
        var populatorFactoryBean = new Jackson2RepositoryPopulatorFactoryBean();
        populatorFactoryBean.setMapper(objectMapper);
        populatorFactoryBean.setResources(new Resource[]{testData});
        return populatorFactoryBean;
    }
}
