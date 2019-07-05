package co.maxkramer.kotlinstarter.support

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import java.lang.annotation.Inherited

@Inherited
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureEmbeddedDatabase(beanName = "dataSource")
annotation class UseEmbeddedPostgres
