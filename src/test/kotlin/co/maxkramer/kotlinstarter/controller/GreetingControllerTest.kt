package co.maxkramer.kotlinstarter.controller

import co.maxkramer.kotlinstarter.service.GreetingService
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.whenever
import javax.persistence.EntityNotFoundException
import javax.validation.ValidationException
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest(GreetingController::class)
class GreetingControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var greetingService: GreetingService

    @Test
    fun `should respond with greeting`() {
        val name = "Max"
        val message = "Hello $name"
        whenever(greetingService.fetchGreeting(eq(name))).thenReturn(message)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/greet")
                .param("name", name)
                .accept(MediaType.TEXT_PLAIN)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string(message))
    }

    @Test
    fun `should return validation error`() {
        whenever(greetingService.fetchGreeting(any())).thenThrow(ValidationException())
        mockMvc.perform(
                MockMvcRequestBuilders.get("/greet")
                        .param("name", "Max")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest)
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.equalTo("Validation error")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.equalTo(HttpStatus.BAD_REQUEST.name)))
    }

    @Test
    fun `should return conflict`() {
        whenever(greetingService.fetchGreeting(any())).thenThrow(IllegalArgumentException())
        mockMvc.perform(
                MockMvcRequestBuilders.get("/greet")
                        .param("name", "Max")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isConflict)
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.equalTo("Illegal argument exception")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.equalTo(HttpStatus.CONFLICT.name)))
    }

    @Test
    fun `should return unknown error`() {
        whenever(greetingService.fetchGreeting(any())).thenThrow(RuntimeException())
        mockMvc.perform(
                MockMvcRequestBuilders.get("/greet")
                        .param("name", "Max")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError)
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.equalTo("Unknown error")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.equalTo(HttpStatus.INTERNAL_SERVER_ERROR.name)))
    }

    @Test
    fun `should return not found error`() {
        whenever(greetingService.fetchGreeting(any())).thenThrow(EntityNotFoundException())
        mockMvc.perform(
                MockMvcRequestBuilders.get("/greet")
                        .param("name", "Max")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound)
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.equalTo("Entity not found")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.equalTo(HttpStatus.NOT_FOUND.name)))
    }
}
