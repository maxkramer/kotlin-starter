package co.maxkramer.kotlinstarter.service

import co.maxkramer.kotlinstarter.repository.GreetingRepository
import org.springframework.stereotype.Service

@Service
class GreetingService(private val greetingRepository: GreetingRepository) {
    fun fetchGreeting(name: String) = greetingRepository.findFirstRandom().renderedMessage(name)
}
