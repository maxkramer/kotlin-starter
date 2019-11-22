package co.maxkramer.kotlinstarter.service

import co.maxkramer.kotlinstarter.model.Greeting
import co.maxkramer.kotlinstarter.repository.GreetingRepository
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class GreetingServiceTest {
    @Mock
    private lateinit var greetingRepository: GreetingRepository

    @InjectMocks
    private lateinit var greetingService: GreetingService

    @BeforeEach
    fun setup() {
        whenever(greetingRepository.findFirstRandom()).thenReturn(Greeting(messageFormat = "Hello %s"))
    }

    @Test
    fun `should return greeting`() {
        val name = "Max"
        val greeting = greetingService.fetchGreeting(name)

        assertEquals("Hello Max", greeting)
    }
}
