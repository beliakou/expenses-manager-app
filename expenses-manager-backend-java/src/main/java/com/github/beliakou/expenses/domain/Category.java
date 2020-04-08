package com.github.beliakou.expenses.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Category(@Id String id, String name) {
}
