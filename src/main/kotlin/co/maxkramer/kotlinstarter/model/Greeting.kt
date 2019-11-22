package co.maxkramer.kotlinstarter.model

import java.time.Instant
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@EntityListeners(AuditingEntityListener::class)
data class Greeting(
    @Id
    @GeneratedValue
    val id: UUID? = null,

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
