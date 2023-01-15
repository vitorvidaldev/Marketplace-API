package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(val purchaseRepository: PurchaseRepository)