package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.Hibernate
import java.util.*

@Entity
@Table(name = "address")
class Address(
    @Id
    val id: UUID,

    @Column(name = "country", columnDefinition = "VARCHAR(20)", nullable = false)
    val country: String,  // TODO maybe enum?

    @Column(name = "state", columnDefinition = "VARCHAR(20)", nullable = false)
    val state: String,

    @Column(name = "city", columnDefinition = "VARCHAR(20)", nullable = false)
    val city: String,
    @Column(name = "street_name", columnDefinition = "VARCHAR(30)", nullable = false)
    val streetName: String,

    @Column(name = "street_number", columnDefinition = "INT", nullable = false) // TODO Verify column definition
    val streetNumber: Int,


    @Column(name = "post_code", columnDefinition = "VARCHAR(20)", nullable = false)
    val postCode: String,
) {
    @Column(name = "complement", columnDefinition = "INT", nullable = true) // TODO verify column definition
    var complement: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String {
        return "Address(id=$id, country='$country', state='$state', city='$city', streetName='$streetName', streetNumber=$streetNumber, postCode='$postCode', complement=$complement)"
    }
}