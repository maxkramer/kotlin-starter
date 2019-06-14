package co.maxkramer.kotlinstarter.service

import co.maxkramer.kotlinstarter.model.Greeting
import org.springframework.stereotype.Service

@Service
class GreetingService {
    private val greetings = listOf(
        "Hello %s!",
        "Hey %s!",
        "Guten Tag %s!",
        "Konichiwa %s!"
    )

    fun greet(name: String): Greeting {
        return Greeting(name.capitalize(), greetings.random())
    }
}
