package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "purchase")
open class Purchase {
    @Id
    lateinit var purchaseId: UUID

    @Column(name = "purchase_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var purchaseDate: Timestamp

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var product: Product

    @Column(name = "payment_type", columnDefinition = "VARCHAR(20)", nullable = false)
    lateinit var paymentType: PaymentTypeEnum

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var buyer: User

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var seller: User
}