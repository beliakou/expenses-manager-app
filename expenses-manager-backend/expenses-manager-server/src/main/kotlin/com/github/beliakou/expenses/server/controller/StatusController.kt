package com.github.beliakou.expenses.server.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusController {

    @RequestMapping("/ping")
    fun ping() : ResponseEntity<String> {
        return ResponseEntity.ok("hello")
    }
}