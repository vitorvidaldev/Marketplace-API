package dev.vitorvidal.marketplace.domain.repository

import dev.vitorvidal.marketplace.domain.entity.Purchase
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PurchaseRepository : JpaRepository<Purchase, UUID>, JpaSpecificationExecutor<Purchase> {
    fun findByIdAndBuyerId(userId: UUID, productId: UUID, pageable: Pageable): Page<Purchase> // TODO validate
}