package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.OfferRepository
import dev.vitorvidal.marketplace.domain.vo.OfferResponseVO
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
}