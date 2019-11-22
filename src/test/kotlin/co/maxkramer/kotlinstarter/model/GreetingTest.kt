package co.maxkramer.kotlinstarter.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreetingTest {
    @Test
    fun `renderedMessage should replace string literal with name`() {
        val greeting = Greeting(messageFormat = "Hello %s")
        assertEquals("Hello Max", greeting.renderedMessage("Max"))
    }

    @Test
    fun `renderedMessage should not return name when missing string literal`() {
        val greeting = Greeting(messageFormat = "Hello")
        assertEquals("Hello", greeting.renderedMessage("Max"))
    }

    @Test
    fun `renderedMessage should capitalise name`() {
        val greeting = Greeting(messageFormat = "Hello %s")
        assertEquals("Hello Max Kramer", greeting.renderedMessage("max kramer"))
    }
}
