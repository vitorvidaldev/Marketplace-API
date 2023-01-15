package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.ProductService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/product")
class ProductController(val productService: ProductService)