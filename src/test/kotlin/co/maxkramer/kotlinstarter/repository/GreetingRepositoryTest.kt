package co.maxkramer.kotlinstarter.repository

import co.maxkramer.kotlinstarter.config.JpaConfig
import co.maxkramer.kotlinstarter.model.Greeting
import co.maxkramer.kotlinstarter.support.UseEmbeddedPostgres
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@UseEmbeddedPostgres
@Import(JpaConfig::class)
class GreetingRepositoryTest {
    @Autowired
    private lateinit var greetingRepository: GreetingRepository

    @Test
    fun `should create a greeting`() {
        val messageFormat = "Hello %s"
        val greeting = Greeting(messageFormat = messageFormat)
        val createdGreeting = greetingRepository.save(greeting)

        // messageFormat isn't exposed on the entity...
        assertEquals(greeting.renderedMessage("Max"), createdGreeting.renderedMessage("Max"))
    }

    @Test
    fun `creating a greeting should set id`() {
        val messageFormat = "Hello %s"
        val greeting = Greeting(messageFormat = messageFormat)
        val createdGreeting = greetingRepository.save(greeting)
        assertNotNull(createdGreeting.id)
    }

    @Test
    fun `creating a greeting should set created at and last updated at`() {
        val messageFormat = "Hello %s"
        val greeting = Greeting(messageFormat = messageFormat)
        val createdGreeting = greetingRepository.save(greeting)

        assertNotNull(createdGreeting.createdAt)
        assertNotNull(createdGreeting.updatedAt)
    }
}
