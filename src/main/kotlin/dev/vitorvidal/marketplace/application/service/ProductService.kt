package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.ProductRepository
import dev.vitorvidal.marketplace.domain.vo.ProductResponseVO
import dev.vitorvidal.marketplace.domain.vo.RegisterProductVO
import dev.vitorvidal.marketplace.domain.vo.UpdateProductVO
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val productRepository: ProductRepository) {
    fun registerNewProduct(registerProductVO: RegisterProductVO): ProductResponseVO? {
        TODO("Not yet implemented")
    }

    fun getProductsByCreatorId(creatorId: UUID): Page<ProductResponseVO>? {
        TODO("Not yet implemented")
    }

    fun getProductById(productId: UUID): ProductResponseVO? {
        TODO("Not yet implemented")
    }

    fun updateProductData(productId: UUID, creatorId: UUID, updateProductDataVO: UpdateProductVO): ProductResponseVO? {
        TODO("Not yet implemented")
    }

    fun deleteProduct(productId: UUID, creatorId: UUID): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }
}