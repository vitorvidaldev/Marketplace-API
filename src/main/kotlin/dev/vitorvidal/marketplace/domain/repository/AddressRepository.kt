package dev.vitorvidal.marketplace.domain.repository

import dev.vitorvidal.marketplace.domain.entity.Address
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AddressRepository : JpaRepository<Address, UUID>, JpaSpecificationExecutor<Address>