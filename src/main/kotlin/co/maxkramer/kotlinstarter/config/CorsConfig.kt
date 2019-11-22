package co.maxkramer.kotlinstarter.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig {

    @Bean
    fun corsConfigurer(@Value("\${cors.allowed-origins}") allowedOrigin: String): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                registry.addMapping("/greet")
                    .allowedMethods("GET", "HEAD", "OPTIONS")
                    .allowedOrigins(allowedOrigin)
                    .allowedHeaders("*")
                    .allowCredentials(true)
            }

            override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
                registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/")

                registry.addResourceHandler("/webjars/**")
                    .addResourceLocations("classpath:/META-INF/resources/webjars/")
            }
        }
    }
}
