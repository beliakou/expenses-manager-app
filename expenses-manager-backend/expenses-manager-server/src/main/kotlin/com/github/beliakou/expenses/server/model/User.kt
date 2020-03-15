package com.github.beliakou.expenses.server.model

import com.fasterxml.jackson.annotation.JsonView
import com.github.beliakou.expenses.server.util.View
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(@Id val id: String?,
                val name: String,
                @JsonView(View.Private::class) val password: String?)