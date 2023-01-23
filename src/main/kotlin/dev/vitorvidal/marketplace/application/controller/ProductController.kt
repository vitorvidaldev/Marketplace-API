package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.ProductService
import dev.vitorvidal.marketplace.domain.vo.ProductResponseVO
import dev.vitorvidal.marketplace.domain.vo.RegisterProductVO
import dev.vitorvidal.marketplace.domain.vo.UpdateProductVO
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rest/v1/product")
class ProductController(val productService: ProductService) {
    @GetMapping("/data")
    fun getProductById(@RequestHeader(name = "productId") productId: UUID): ResponseEntity<ProductResponseVO> =
        ResponseEntity.ok().body(productService.getProductById(productId))

    @GetMapping
    fun getProductsByCreatorId(@RequestHeader(name = "creatorId") creatorId: UUID): ResponseEntity<Page<ProductResponseVO>> =
        ResponseEntity.ok().body(productService.getProductsByCreatorId(creatorId))

    @PostMapping
    fun registerNewProduct(@RequestBody @Valid registerProductVO: RegisterProductVO): ResponseEntity<ProductResponseVO> =
        ResponseEntity.status(
            HttpStatus.CREATED
        ).body(productService.registerNewProduct(registerProductVO))

    @PutMapping("/data")
    fun updateProductData(
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID,
        @RequestBody @Valid updateProductDataVO: UpdateProductVO
    ): ResponseEntity<ProductResponseVO> =
        ResponseEntity.ok().body(productService.updateProductData(productId, creatorId, updateProductDataVO))

    @DeleteMapping
    fun deleteProduct(
        @RequestHeader(name = "productId") productId: UUID,
        @RequestHeader(name = "creatorId") creatorId: UUID
    ): ResponseEntity<Void> = productService.deleteProduct(productId, creatorId)
}