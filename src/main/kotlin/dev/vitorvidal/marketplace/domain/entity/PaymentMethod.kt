package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "payment_method")
open class PaymentMethod {
    @Id
    lateinit var paymentMethodId: UUID

    lateinit var creditCard: CreditCard

    lateinit var debitCard: DebitCard

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var user: User
}