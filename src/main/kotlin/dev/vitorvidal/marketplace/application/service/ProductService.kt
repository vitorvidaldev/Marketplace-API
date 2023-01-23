package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.configuration.exception.ProductNotFoundException
import dev.vitorvidal.marketplace.domain.repository.ProductRepository
import dev.vitorvidal.marketplace.domain.vo.ProductResponseVO
import dev.vitorvidal.marketplace.domain.vo.RegisterProductVO
import dev.vitorvidal.marketplace.domain.vo.UpdateProductVO
import dev.vitorvidal.marketplace.util.Constants.Companion.PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val productRepository: ProductRepository) {
    fun getProductById(productId: UUID): ProductResponseVO? {
        val optionalProduct = productRepository.findById(productId)
        if (optionalProduct.isPresent) return optionalProduct.get().toProductResponseVO()
        throw ProductNotFoundException(PRODUCT_NOT_FOUND_EXCEPTION_MESSAGE)
    }

    fun getProductsByCreatorId(creatorId: UUID): Page<ProductResponseVO>? {
        TODO("Not yet implemented")
    }

    fun registerNewProduct(registerProductVO: RegisterProductVO): ProductResponseVO? {
        TODO("Not yet implemented")
    }

    fun updateProductData(productId: UUID, creatorId: UUID, updateProductDataVO: UpdateProductVO): ProductResponseVO? {
        TODO("Not yet implemented")
    }

    fun deleteProduct(productId: UUID, creatorId: UUID): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }
}