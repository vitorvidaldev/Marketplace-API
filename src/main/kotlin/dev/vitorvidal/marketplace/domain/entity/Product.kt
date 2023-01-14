package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "product")
open class Product {
    @Id
    lateinit var productId: UUID

    @Column(name = "name", columnDefinition = "VARCHAR(60)", nullable = false)
    lateinit var productName: String

    @Column(name = "description", columnDefinition = "VARCHAR(500)", nullable = false)
    lateinit var productDescription: String

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var creator: User

    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var creationDate: Timestamp

    @Column(name = "last_updated_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var lastUpdatedDate: Timestamp
}