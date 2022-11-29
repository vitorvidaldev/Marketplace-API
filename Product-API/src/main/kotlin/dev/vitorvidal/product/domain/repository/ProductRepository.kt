package dev.vitorvidal.product.domain.repository

import dev.vitorvidal.product.domain.entity.ProductEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository : PagingAndSortingRepository<ProductEntity, UUID>, ProductRepositoryCustom {
}