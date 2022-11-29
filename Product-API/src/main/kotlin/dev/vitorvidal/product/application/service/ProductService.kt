package dev.vitorvidal.product.application.service

import dev.vitorvidal.product.domain.dto.ProductDTO
import dev.vitorvidal.product.domain.dto.RegisterProductDTO
import dev.vitorvidal.product.domain.entity.ProductEntity
import dev.vitorvidal.product.domain.repository.ProductRepository
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Slf4j
@Service
class ProductService(val productRepository: ProductRepository) {
    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    fun getProducts(productName: String?, pageSize: Int, pageNumber: Int): Page<ProductDTO> {
        val page = PageRequest.of(pageNumber, pageSize)
        val productPage = productRepository.findByFilter(productName, page)

        // Map product entity to product dto
        return productPage.map { entity ->
            ProductDTO(
                entity.productId
            )
        }
    }

    fun getProductById(productId: UUID): ProductDTO? {
        val optionalProduct = productRepository.findById(productId)

        if (optionalProduct.isPresent) {
            val productEntity = optionalProduct.get()

            // Map product entity to product dto
            return ProductDTO(
                productEntity.
            )
        }

        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")
    }

    fun registerProduct(registerProductDTO: RegisterProductDTO): ProductDTO? {
        val productEntity = ProductEntity(
            registerProductVO.productName,
            registerProductVO.productBrand,
            registerProductVO.productPrice,
            registerProductVO.userId
        )

        val createdProduct = productRepository.save(productEntity)

        return ProductVO(
            createdProduct.productId,
            createdProduct.productName,
            createdProduct.productBrand,
            createdProduct.productPrice,
            createdProduct.creationDate,
            productEntity.isActive,
            createdProduct.lastUpdateDate,
            createdProduct.userId
        )
    }

    fun deleteProduct(productId: UUID): ResponseEntity<Void> {
        return try {
            productRepository.deleteById(productId)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            log.error("Did not find product to delete")
            ResponseEntity.notFound().build()
        }
    }
}