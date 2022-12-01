package dev.vitorvidal.product.domain.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "product")
class ProductEntity(
    @Id
    var productId: UUID = UUID.randomUUID(),
    var name: String,
    var description: String,
    var owner: String, // Make this a user? Should there be a user microservice?
    val createdAt: LocalDateTime = LocalDateTime.now(),
    var lastUpdatedAt: LocalDateTime
)