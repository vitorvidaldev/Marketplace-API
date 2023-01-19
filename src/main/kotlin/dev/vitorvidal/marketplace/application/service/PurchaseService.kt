package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.PurchaseRepository
import dev.vitorvidal.marketplace.domain.vo.PurchaseResponseVO
import org.springframework.stereotype.Service
import java.util.*

@Service
class PurchaseService(val purchaseRepository: PurchaseRepository) {
    fun getPurchaseDetail(purchaseId: UUID, userId: UUID): PurchaseResponseVO {
        TODO("Not yet implemented")
    }

    fun getPurchasesFromUser(userId: UUID): List<PurchaseResponseVO> {
        TODO("Not yet implemented")
    }
}