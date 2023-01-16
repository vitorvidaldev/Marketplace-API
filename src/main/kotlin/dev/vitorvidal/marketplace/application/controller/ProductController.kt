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
    @GetMapping("/{productId}")
    fun getProductById(@PathVariable(name = "productId") productId: UUID): ResponseEntity<ProductResponseVO> =
        ResponseEntity.ok().body(productService.getProductById(productId))

    @GetMapping("/{creatorId}")
    fun getProductsByCreatorId(@PathVariable(name = "creatorId") creatorId: UUID): ResponseEntity<Page<ProductResponseVO>> =
        ResponseEntity.ok().body(productService.getProductsByCreatorId(creatorId))

    @PostMapping
    fun registerNewProduct(@RequestBody @Valid registerProductVO: RegisterProductVO): ResponseEntity<ProductResponseVO> =
        ResponseEntity.status(
            HttpStatus.CREATED
        ).body(productService.registerNewProduct(registerProductVO))

    @PutMapping("/data/{productId}/user/{creatorId}")
    fun updateProductData(
        @PathVariable(name = "productId") productId: UUID,
        @PathVariable(name = "creatorId") creatorId: UUID,
        @RequestBody @Valid updateProductDataVO: UpdateProductVO
    ): ResponseEntity<ProductResponseVO> =
        ResponseEntity.ok().body(productService.updateProductData(productId, creatorId, updateProductDataVO))

    @DeleteMapping("/{productId}/user/{creatorId}")
    fun deleteProduct(
        @PathVariable(name = "productId") productId: UUID,
        @PathVariable(name = "creatorId") creatorId: UUID
    ): ResponseEntity<Void> = productService.deleteProduct(productId, creatorId)
}