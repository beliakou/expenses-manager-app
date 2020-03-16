package com.github.beliakou.expenses.server.config

import com.github.beliakou.expenses.server.util.View
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice

@ControllerAdvice
class JsonViewAdvice : AbstractMappingJacksonResponseBodyAdvice() {
    override fun beforeBodyWriteInternal(bodyContainer: MappingJacksonValue, contentType: MediaType, returnType: MethodParameter, request: ServerHttpRequest, response: ServerHttpResponse) {
        bodyContainer.serializationView = View.Public::class.java
    }
}