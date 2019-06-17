package co.maxkramer.kotlinstarter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinStarterApplication

fun main(args: Array<String>) {
    runApplication<KotlinStarterApplication>(*args)
}
