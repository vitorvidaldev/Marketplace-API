package dev.vitorvidal.marketplace.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class AddressVO(
    @JsonProperty(value = "address_id")
    val id: UUID,
    @JsonProperty(value = "country")
    val country: String,  // TODO maybe enum?
    @JsonProperty(value = "state")
    val state: String,
    @JsonProperty(value = "city")
    val city: String,
    @JsonProperty(value = "street_name")
    val streetName: String,
    @JsonProperty(value = "street_number")
    val streetNumber: Int,
    @JsonProperty(value = "post_code")
    val postCode: String,
)
