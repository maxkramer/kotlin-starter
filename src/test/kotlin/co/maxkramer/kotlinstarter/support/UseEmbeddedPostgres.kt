package co.maxkramer.kotlinstarter.support

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import java.lang.annotation.Inherited
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase

@Inherited
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureEmbeddedDatabase(beanName = "dataSource")
annotation class UseEmbeddedPostgres
