package co.maxkramer.kotlinstarter.controller

import co.maxkramer.kotlinstarter.service.GreetingService
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
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
}
