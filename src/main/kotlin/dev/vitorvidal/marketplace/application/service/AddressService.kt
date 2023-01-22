package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.entity.Address
import dev.vitorvidal.marketplace.domain.repository.AddressRepository
import dev.vitorvidal.marketplace.domain.vo.RegisterAddressVO
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService(val addressRepository: AddressRepository) {

    fun registerUserAddress(address: RegisterAddressVO): Address = addressRepository.save(
        Address(
            UUID.randomUUID(),
            address.country,
            address.state,
            address.city,
            address.streetName,
            address.streetNumber,
            address.postCode
        )
    )
}