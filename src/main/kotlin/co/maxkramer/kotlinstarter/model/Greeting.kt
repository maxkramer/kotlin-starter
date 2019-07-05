package co.maxkramer.kotlinstarter.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Greeting(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int? = null,

    @Size(max = 100)
    private val messageFormat: String,

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: Instant? = null,

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: Instant? = null
) {
    fun renderedMessage(name: String): String {
        val words = name.split(Regex("\\s"))
        val wordsWithUppercaseFirstLetter = words.map(String::capitalize)
        return messageFormat.format(wordsWithUppercaseFirstLetter.joinToString(" "))
    }
}
