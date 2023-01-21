package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.OfferService
import dev.vitorvidal.marketplace.domain.vo.OfferResponseVO
import dev.vitorvidal.marketplace.domain.vo.UpdateOfferVO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rest/v1/offer")
class OfferController(val offerService: OfferService) {
    @GetMapping("/details")
    fun getOfferDetails(
        @RequestHeader(name = "offerId") offerId: UUID,
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID
    ): ResponseEntity<OfferResponseVO> =
        ResponseEntity.ok().body(offerService.getOfferDetails(offerId, productId, creatorId))

    @GetMapping
    fun getOffersFromProduct(
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID
    ): ResponseEntity<List<OfferResponseVO>> =
        ResponseEntity.ok().body(offerService.getOffersFromProduct(productId, creatorId))

    @PostMapping
    fun createOffer(
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID
    ): ResponseEntity<OfferResponseVO> =
        ResponseEntity.status(HttpStatus.CREATED).body(offerService.createOffer(productId, creatorId))

    @DeleteMapping
    fun deleteOffer(
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID
    ): ResponseEntity<Void> = offerService.deleteOffer(productId, creatorId)

    @PutMapping
    fun updateOffer(
        @RequestHeader(name = "offerId") offerId: UUID,
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID,
        @RequestBody @Valid updateOfferVO: UpdateOfferVO
    ): ResponseEntity<OfferResponseVO> =
        ResponseEntity.ok().body(offerService.updateOffer(offerId, productId, creatorId, updateOfferVO))
}