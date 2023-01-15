package dev.vitorvidal.marketplace.domain.entity

import dev.vitorvidal.marketplace.domain.enum.PaymentTypeEnum
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "purchase")
class Purchase(
    @Id
    val id: UUID,
    @Column(name = "purchase_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val purchaseDate: Timestamp,
    @Column(name = "payment_type", columnDefinition = "VARCHAR(20)", nullable = false)
    val paymentType: PaymentTypeEnum,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
    @ManyToOne(fetch = FetchType.LAZY)
    val buyer: User,
    @ManyToOne(fetch = FetchType.LAZY)
    val seller: User
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
    override fun toString(): String = "Purchase(id=$id, purchaseDate=$purchaseDate, paymentType=$paymentType)"
}