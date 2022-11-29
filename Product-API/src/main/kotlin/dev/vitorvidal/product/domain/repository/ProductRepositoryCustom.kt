package dev.vitorvidal.product.domain.repository

import dev.vitorvidal.product.domain.entity.ProductEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProductRepositoryCustom {
    fun findByFilter(productName: String?, page: Pageable): Page<ProductEntity>
}