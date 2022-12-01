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
import java.time.LocalDateTime
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

        // Note (Vitor): Model mapper ?????
        return productPage.map { entity ->
            ProductDTO(
                entity.productId,
                entity.name,
                entity.description,
                entity.owner,
                entity.createdAt,
                entity.lastUpdatedAt
            )
        }
    }

    fun getProductById(productId: UUID): ProductDTO? {
        val optionalProduct = productRepository.findById(productId)

        if (optionalProduct.isPresent) {
            val entity = optionalProduct.get()

            // Note (Vitor): Model mapper ?????
            return ProductDTO(
                entity.productId,
                entity.name,
                entity.description,
                entity.owner,
                entity.createdAt,
                entity.lastUpdatedAt
            )
        }

        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found")
    }

    fun registerProduct(registerProductDTO: RegisterProductDTO): ProductDTO? {
        val productEntity = ProductEntity(
            name = registerProductDTO.productName,
            description = registerProductDTO.productDescription,
            owner = registerProductDTO.productOwner,
            lastUpdatedAt = LocalDateTime.now()
        )

        val createdProduct = productRepository.save(productEntity)

        // Note (Vitor): Model mapper ??????
        return ProductDTO(
            createdProduct.productId,
            createdProduct.name,
            createdProduct.description,
            createdProduct.owner,
            createdProduct.createdAt,
            createdProduct.lastUpdatedAt
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