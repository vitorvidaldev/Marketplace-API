package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.PurchaseService
import dev.vitorvidal.marketplace.domain.vo.PurchaseResponseVO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/rest/v1/purchase")
class PurchaseController(val purchaseService: PurchaseService) {
    @GetMapping("/{purchaseId}/user/{userId}")
    fun getPurchaseDetail(
        @PathVariable(name = "purchaseId") purchaseId: UUID,
        @PathVariable(name = "userId") userId: UUID
    ): ResponseEntity<PurchaseResponseVO> =
        ResponseEntity.ok().body(purchaseService.getPurchaseDetail(purchaseId, userId))

    @GetMapping("/user/{userId}")
    fun getPurchasesFromUser(@PathVariable(name = "userId") userId: UUID): ResponseEntity<List<PurchaseResponseVO>> =
        ResponseEntity.ok().body(purchaseService.getPurchasesFromUser(userId))
}