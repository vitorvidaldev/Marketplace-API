package dev.vitorvidal.marketplace.domain.vo

import java.util.*

data class RegisterUserVO(
    val id: UUID,
    val fullName: String,
    val email: String,
    val password: String,
    val cpf: String
)