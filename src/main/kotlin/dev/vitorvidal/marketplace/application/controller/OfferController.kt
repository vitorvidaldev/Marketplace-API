package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.OfferService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/offer")
class OfferController(val offerService: OfferService) {
    // TODO create offer, update offer, delete offer, retrieve single offer for product,
    //  retrieve every offer from same product
}