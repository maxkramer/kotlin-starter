package co.maxkramer.kotlinstarter.repository

import co.maxkramer.kotlinstarter.model.Greeting
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface GreetingRepository: CrudRepository<Greeting, Int> {
    @Query("SELECT * FROM greeting ORDER BY random()", nativeQuery = true)
    fun findFirstRandom(): Greeting
}
