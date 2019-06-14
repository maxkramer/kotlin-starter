package co.maxkramer.kotlinstarter.controller

import co.maxkramer.kotlinstarter.service.GreetingService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(
    private val greetingService: GreetingService
) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/greet")
    fun greet(@RequestParam name: String): String {
        logger.info("Greeting $name")
        return greetingService.greet(name).renderedMessage
    }
}
