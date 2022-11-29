package dev.vitorvidal.product.application.controller

import dev.vitorvidal.product.application.service.ProductService
import dev.vitorvidal.product.domain.dto.ProductDTO
import dev.vitorvidal.product.domain.dto.RegisterProductDTO
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/rest/v1/products")
class ProductController(val productService: ProductService) {

    @GetMapping
    fun getProducts(
        @RequestParam(value = "name", required = false) productName: String?,
        @RequestParam(value = "page", required = false, defaultValue = "0") pageNumber: Int,
        @RequestParam(value = "size", required = false, defaultValue = "30") pageSize: Int
    ): ResponseEntity<Page<ProductDTO>> {
        val products = productService.getProducts(productName, pageNumber, pageSize)
        return ResponseEntity.ok().body(products)
    }

    @GetMapping("/{productId}")
    fun getProductById(@PathVariable(value = "productId") productId: UUID): ResponseEntity<ProductDTO> {
        val productDTO = productService.getProductById(productId)
        return ResponseEntity.ok().body(productDTO)
    }

    @PostMapping
    fun registerProduct(@RequestBody @Valid registerProductDTO: RegisterProductDTO): ResponseEntity<ProductDTO> {
        val productDTO = productService.registerProduct(registerProductDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO)
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable(value = "productId") productId: UUID): ResponseEntity<Void> {
        productService.deleteProduct(productId)
        return ResponseEntity.noContent().build()
    }
}