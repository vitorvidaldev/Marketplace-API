package dev.vitorvidal.marketplace.domain.repository

import dev.vitorvidal.marketplace.domain.entity.Offer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OfferRepository : JpaRepository<Offer, UUID>, JpaSpecificationExecutor<Offer>