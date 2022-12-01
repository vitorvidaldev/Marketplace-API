package dev.vitorvidal.product.domain.dto

import java.time.LocalDateTime
import java.util.*

data class ProductDTO(
    val productId: UUID,
    val productName: String,
    val productDescription: String,
    val owner: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)