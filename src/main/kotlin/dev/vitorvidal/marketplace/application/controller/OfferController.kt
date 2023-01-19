package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.OfferService
import dev.vitorvidal.marketplace.domain.vo.OfferResponseVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/rest/v1/offer")
class OfferController(val offerService: OfferService) {
    // TODO create new offer
    // TODO delete offer
    // TODO update offer
    @GetMapping("/{offerId}/product/{productId}/user/{userId}")
    fun getOfferDetails(
        @PathVariable(name = "offerId") offerId: UUID,
        @PathVariable(name = "productId") productId: UUID,
        @PathVariable(name = "userId") userId: UUID
    ): ResponseEntity<OfferResponseVO> =
        ResponseEntity.ok().body(offerService.getOfferDetails(offerId, productId, userId))

    @GetMapping("/product/{productId}/user/{userId}")
    fun getOffersFromProduct(
        @PathVariable(name = "productId") productId: UUID,
        @PathVariable(name = "userId") userId: UUID
    ): ResponseEntity<List<OfferResponseVO>> =
        ResponseEntity.ok().body(offerService.getOffersFromProduct(productId, userId))
}