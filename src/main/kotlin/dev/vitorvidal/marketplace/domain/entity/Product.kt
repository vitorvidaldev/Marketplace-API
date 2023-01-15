package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "product")
class Product(
    @Id
    val id: UUID,
    @Column(name = "name", columnDefinition = "VARCHAR(60)", nullable = false)
    val productName: String,
    @Column(name = "description", columnDefinition = "VARCHAR(500)", nullable = false)
    val productDescription: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val creator: User,
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val creationDate: Timestamp,
    @Column(name = "last_updated_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val lastUpdatedDate: Timestamp
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
    override fun toString(): String =
        "Product(id=$id, productName='$productName', productDescription='$productDescription', creationDate=$creationDate, lastUpdatedDate=$lastUpdatedDate)"
}