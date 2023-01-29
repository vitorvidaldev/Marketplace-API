package dev.vitorvidal.marketplace.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp
import java.util.*

@JsonIgnoreProperties
data class UserResponseVO(
    @JsonProperty(value = "user_id")
    val id: UUID,
    @JsonProperty(value = "full_name")
    val fullName: String,
    @JsonProperty(value = "email")
    val email: String,
    @JsonProperty(value = "creation_date")
    val creationDate: Timestamp,
    @JsonProperty(value = "last_updated_date")
    val lastUpdatedDate: Timestamp,
    @JsonProperty(value = "address")
    val address: AddressVO?
)
