package dev.vitorvidal.marketplace.domain.repository

import dev.vitorvidal.marketplace.domain.entity.PaymentMethod
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PaymentMethodRepository : JpaRepository<PaymentMethod, UUID>, JpaSpecificationExecutor<PaymentMethod>