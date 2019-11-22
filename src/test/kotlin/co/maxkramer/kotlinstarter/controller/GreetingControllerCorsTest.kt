package co.maxkramer.kotlinstarter.controller

import co.maxkramer.kotlinstarter.KotlinStarterApplication
import co.maxkramer.kotlinstarter.service.GreetingService
import co.maxkramer.kotlinstarter.support.UseEmbeddedPostgres
import com.nhaarman.mockitokotlin2.whenever
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.web.context.WebServerApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN
import org.springframework.http.HttpHeaders.ORIGIN
import org.springframework.http.HttpStatus.FORBIDDEN
import org.springframework.http.HttpStatus.OK

@UseEmbeddedPostgres
@Import(value = [KotlinStarterApplication::class])
@SpringBootTest(webEnvironment = RANDOM_PORT, properties = [ "cors.allowed-origins = https://trusted-domain.de" ])
class GreetingControllerCorsTest {

    @Autowired
    private lateinit var applicationContext: WebServerApplicationContext

    @MockBean
    private lateinit var greetingService: GreetingService

    private val validOrigin = "https://trusted-domain.de"
    private val invalidOrigin = "https://some-shady.url"

    @Test
    fun `GET greet endpoint allows valid origin and returns OK`() {
        val greetingName = "My Name"
        whenever(greetingService.fetchGreeting(greetingName)).thenReturn("Hello")
        given()
            .port(applicationContext.webServer.port)
            .header(ORIGIN, validOrigin)
            .param("name", greetingName)
            .get("/greet")
            .then()
            .header(ACCESS_CONTROL_ALLOW_ORIGIN, validOrigin)
            .statusCode(OK.value())
    }

    @Test
    fun `GET greet endpoint does not allow invalid origin and returns FORBIDDEN`() {
        given()
            .port(applicationContext.webServer.port)
            .header(ORIGIN, invalidOrigin)
            .param("name", "My Name")
            .get("/greet")
            .then()
            .statusCode(FORBIDDEN.value())
    }
}
