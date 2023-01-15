package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.AddressRepository
import org.springframework.stereotype.Service

@Service
class AddressService(val addressRepository: AddressRepository)