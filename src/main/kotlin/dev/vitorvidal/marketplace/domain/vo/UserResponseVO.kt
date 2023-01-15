package dev.vitorvidal.marketplace.domain.vo

import dev.vitorvidal.marketplace.domain.entity.Address
import java.sql.Timestamp
import java.util.*

data class UserResponseVO(
    val id: UUID,
    val fullName: String,
    val email: String,
    val creationDate: Timestamp,
    val lastUpdatedDate: Timestamp,
    val address: Address?
)
