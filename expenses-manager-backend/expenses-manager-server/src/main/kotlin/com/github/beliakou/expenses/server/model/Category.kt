package com.github.beliakou.expenses.server.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Category(@Id val id: String?, val name: String)