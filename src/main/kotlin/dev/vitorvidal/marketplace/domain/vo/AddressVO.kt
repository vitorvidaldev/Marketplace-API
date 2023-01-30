package dev.vitorvidal.marketplace.domain.vo

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonInclude
@JsonIgnoreProperties(ignoreUnknown = true)
data class AddressVO(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "address_id")
    val id: UUID,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "country")
    val country: String,  // TODO maybe enum?
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "state")
    val state: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "city")
    val city: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "street_name")
    val streetName: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "street_number")
    val streetNumber: Int,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "post_code")
    val postCode: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "complement")
    var complement: Int? = null
)
