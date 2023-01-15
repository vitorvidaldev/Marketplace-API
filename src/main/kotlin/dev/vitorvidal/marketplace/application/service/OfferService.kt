package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.OfferRepository
import org.springframework.stereotype.Service

@Service
class OfferService(val offerRepository: OfferRepository)