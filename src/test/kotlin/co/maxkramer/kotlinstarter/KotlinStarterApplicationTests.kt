package co.maxkramer.kotlinstarter

import co.maxkramer.kotlinstarter.support.UseEmbeddedPostgres
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@UseEmbeddedPostgres
class KotlinStarterApplicationTests {
    @Test
    fun contextLoads() {
    }
}
