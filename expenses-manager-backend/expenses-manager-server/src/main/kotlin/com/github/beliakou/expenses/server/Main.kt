package com.github.beliakou.expenses.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ExpensesApp

fun main(args: Array<String>) {
    runApplication<ExpensesApp>(*args)
}