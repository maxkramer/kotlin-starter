package co.maxkramer.kotlinstarter.controller

import co.maxkramer.kotlinstarter.model.dto.ErrorResponse
import javassist.NotFoundException
import javax.persistence.EntityNotFoundException
import javax.validation.ValidationException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorResponseHandler {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(value = [EntityNotFoundException::class, NotFoundException::class])
    fun handleEntityNotFoundException(exception: EntityNotFoundException): ResponseEntity<Any> {
        log.error("Handling resource not found error", exception)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse(HttpStatus.NOT_FOUND, "Entity not found", null))
    }

    @ExceptionHandler
    fun handleUnknownError(exception: Exception): ResponseEntity<Any> {
        log.error("Handling internal server error", exception)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception.message ?: "Unknown error", null))
    }

    @ExceptionHandler(value = [IllegalArgumentException::class, IllegalStateException::class])
    fun handleConflict(exception: Exception): ResponseEntity<Any> {
        log.error("Handling conflict", exception)
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ErrorResponse(HttpStatus.CONFLICT, exception.message ?: "Illegal argument exception", null))
    }

    @ExceptionHandler
    fun handleValidationException(exception: ValidationException): ResponseEntity<Any> {
        log.error("Handling validation error", exception)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse(HttpStatus.BAD_REQUEST, exception.message ?: "Validation error", null))
    }
}
