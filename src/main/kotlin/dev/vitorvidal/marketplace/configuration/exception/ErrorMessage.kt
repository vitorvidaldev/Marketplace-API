package dev.vitorvidal.marketplace.configuration.exception

import java.time.LocalDateTime

data class ErrorMessage(
    val statusCode: Int,
    val timestamp: LocalDateTime,
    val message: String?,
    val description: String
)
