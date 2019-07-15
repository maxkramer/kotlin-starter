package co.maxkramer.kotlinstarter

import co.maxkramer.kotlinstarter.support.UseEmbeddedPostgres
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
@UseEmbeddedPostgres
class KotlinStarterApplicationTests {
    @Test
    fun contextLoads() {
    }
}
