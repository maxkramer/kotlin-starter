package co.maxkramer.kotlinstarter.model.dto

import org.springframework.http.HttpStatus

data class ErrorResponse<T>(
    val code: HttpStatus,
    val message: String,
    val details: T? = null
)
