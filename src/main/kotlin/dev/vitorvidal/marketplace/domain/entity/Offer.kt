package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "offer")
class Offer(
    @Id
    val id: UUID,
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val creationDate: Timestamp,
    @Column(name = "last_updated_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val lastUpdatedDate: Timestamp,
    @Column(name = "price", columnDefinition = "BIGDECIMAL", nullable = false)
    val price: BigDecimal,
    @ManyToOne(fetch = FetchType.LAZY)
    val creator: User,
    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String {
        return "Offer(id=$id, creationDate=$creationDate, lastUpdatedDate=$lastUpdatedDate, price=$price)"
    }
}