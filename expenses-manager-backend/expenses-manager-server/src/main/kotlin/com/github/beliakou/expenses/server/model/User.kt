package com.github.beliakou.expenses.server.model

import org.springframework.data.annotation.Id

data class User (@Id val id: String, val name: String, val password: String)