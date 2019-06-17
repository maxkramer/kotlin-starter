package co.maxkramer.kotlinstarter.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
data class Greeting(
    @Id
    @GeneratedValue
    val id: Int? = null,

    @Size(max = 100)
    private val messageFormat: String
) {
    fun renderedMessage(name: String): String {
        val words = name.split(Regex("\\s"))
        val wordsWithUppercaseFirstLetter = words.map(String::capitalize)
        return messageFormat.format(wordsWithUppercaseFirstLetter.joinToString(" "))
    }
}
