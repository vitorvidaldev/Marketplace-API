package dev.vitorvidal.marketplace.domain.vo

data class RegisterUserVO(
    val fullName: String,
    val email: String,
    val password: String,
    val cpf: String
)