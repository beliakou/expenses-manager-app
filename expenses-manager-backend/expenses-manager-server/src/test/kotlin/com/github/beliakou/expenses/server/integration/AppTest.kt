package com.github.beliakou.expenses.server.integration

import com.github.beliakou.expenses.server.ExpensesApp
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@SpringBootTest
@ContextConfiguration(classes = [ExpensesApp::class, TestConfig::class])
@AutoConfigureMockMvc
class AppTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun `application is up`() {
        mockMvc.perform(get("/ping")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk)
                .andExpect(content().string(containsString("hello")))
    }

    @Test
    @Throws(Exception::class)
    fun `user data from mongo returned`() {
        mockMvc.perform(get("/user").param("name", "Vasya")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk)
                .andExpect(jsonPath("$.name", `is`("Vasya")))
    }

    @Test
    @Throws(Exception::class)
    fun `password is not presented in response`() {
        mockMvc.perform(get("/user").param("name", "Vasya")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk)
                .andExpect(jsonPath("$.password").doesNotExist())
    }
}