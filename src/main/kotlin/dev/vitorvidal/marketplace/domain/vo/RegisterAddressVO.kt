package dev.vitorvidal.marketplace.domain.vo

data class RegisterAddressVO(
    val country: String,
    val state: String,
    val city: String,
    val streetName: String,
    val streetNumber: Int,
    val postCode: String,
    val complement: Int?
)
