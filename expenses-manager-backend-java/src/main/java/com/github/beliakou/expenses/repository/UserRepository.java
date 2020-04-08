package com.github.beliakou.expenses.repository;

import com.github.beliakou.expenses.domain.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {

    private MongoTemplate mongoTemplate;

    public UserRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Optional<User> findUser(String name) {
        return Optional.ofNullable(this.mongoTemplate.findOne(
                Query.query(Criteria.where("name").is(name)), User.class, "user"));
    }
}
