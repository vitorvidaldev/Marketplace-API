package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.PurchaseService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/purchase")
class PurchaseController(val purchaseService: PurchaseService)