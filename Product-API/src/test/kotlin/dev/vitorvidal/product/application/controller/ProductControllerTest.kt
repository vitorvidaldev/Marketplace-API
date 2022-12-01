package dev.vitorvidal.product.application.controller

import dev.vitorvidal.product.application.service.ProductService
import dev.vitorvidal.product.domain.dto.ProductDTO
import dev.vitorvidal.product.util.TestUtils.pageNumber
import dev.vitorvidal.product.util.TestUtils.pageSize
import dev.vitorvidal.product.util.TestUtils.productName
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.springframework.data.domain.PageImpl
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
internal class ProductControllerTest {
    @InjectMocks
    lateinit var productController: ProductController

    @Mock
    lateinit var productService: ProductService

    @Test
    fun shouldGetProductsCorrectly() {
        val productDTOMock = mock(ProductDTO::class.java)

        `when`(productService.getProducts(productName, pageSize, pageNumber))
            .thenReturn(PageImpl(listOf(productDTOMock)))

        val response = productController.getProducts(productName, pageSize, pageNumber)

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        assertEquals(listOf(productDTOMock), response.body?.content)

        verify(productService).getProducts(productName, pageSize, pageNumber)
    }

    @Test
    fun shouldGetEmptyProductsCorrectly() {

        `when`(productService.getProducts(productName, pageSize, pageNumber))
            .thenReturn(PageImpl(emptyList()))

        val response = productController.getProducts(productName, pageSize, pageNumber)

        assertNotNull(response)
        assertEquals(HttpStatus.OK, response.statusCode)
        assertNotNull(response.body)
        response.body?.content?.let { assertEquals(0, it.size) }

        verify(productService).getProducts(productName, pageSize, pageNumber)
    }

    @Test
    fun getProductById() {
    }

    @Test
    fun registerProduct() {
    }

    @Test
    fun deleteProduct() {
    }

    @Test
    fun getProductService() {
    }
}