package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.OfferRepository
import dev.vitorvidal.marketplace.domain.vo.OfferResponseVO
import dev.vitorvidal.marketplace.domain.vo.UpdateOfferVO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class OfferService(val offerRepository: OfferRepository) {
    fun getOfferDetails(offerId: UUID, productId: UUID, userId: UUID): OfferResponseVO {
        TODO("Not yet implemented")
    }

    fun getOffersFromProduct(lproductId: UUID, userId: UUID): List<OfferResponseVO> {
        TODO("Not yet implemented")
    }

    fun createOffer(productId: UUID, creatorId: UUID): OfferResponseVO {
        TODO("Not yet implemented")
    }

    fun deleteOffer(productId: UUID, creatorId: UUID): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    fun updateOffer(offerId: UUID, productId: UUID, creatorId: UUID, updateOfferVO: UpdateOfferVO): OfferResponseVO {
        TODO("Not yet implemented")
    }
}