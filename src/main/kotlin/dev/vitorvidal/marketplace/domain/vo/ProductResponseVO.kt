package dev.vitorvidal.marketplace.domain.vo

import java.sql.Timestamp
import java.util.*

data class ProductResponseVO(
    val id: UUID,
    val productName: String,
    val productDescription: String,
    val creator: UserResponseVO,
    val creationDate: Timestamp,
    val lastUpdatedDate: Timestamp
)
