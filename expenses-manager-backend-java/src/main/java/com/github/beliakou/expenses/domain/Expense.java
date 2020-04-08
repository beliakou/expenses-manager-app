package com.github.beliakou.expenses.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document
public record Expense(@Id String id, String userId, LocalDate date, Category category, BigDecimal amount) {
}
