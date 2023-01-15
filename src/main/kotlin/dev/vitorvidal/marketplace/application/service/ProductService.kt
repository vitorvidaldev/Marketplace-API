package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(val productRepository: ProductRepository)