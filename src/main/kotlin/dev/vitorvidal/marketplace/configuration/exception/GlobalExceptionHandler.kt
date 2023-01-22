package dev.vitorvidal.marketplace.configuration.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundException(exception: UserNotFoundException, request: WebRequest): ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            LocalDateTime.now(),
            exception.message,
            request.getDescription(false)
        )
        return ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND)
    }

    // Fallback exception handler. Every other exception handler should be declared above this line
    @ExceptionHandler(Exception::class)
    fun globalExceptionHandler(exception: Exception, request: WebRequest): ResponseEntity<ErrorMessage> {
        val errorMessage = ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            LocalDateTime.now(),
            exception.message,
            request.getDescription(false)
        )
        return ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}