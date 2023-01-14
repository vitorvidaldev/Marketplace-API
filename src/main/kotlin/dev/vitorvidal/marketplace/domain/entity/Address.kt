package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "address")
class Address {
    // TODO define id
    @Column(name = "country", columnDefinition = "VARCHAR(20)", nullable = false)
    lateinit var country: String // TODO maybe enum?

    @Column(name = "state", columnDefinition = "VARCHAR(20)", nullable = false)
    lateinit var state: String

    @Column(name = "city", columnDefinition = "VARCHAR(20)", nullable = false)
    lateinit var city: String

    @Column(name = "street_name", columnDefinition = "VARCHAR(30)", nullable = false)
    lateinit var streetName: String

    @Column(name = "street_number", columnDefinition = "INT", nullable = false) // TODO Verify column definition
    lateinit var streetNumber: Int

    @Column(name = "complement", columnDefinition = "INT", nullable = true) // TODO verify column definition
    lateinit var complement: Int?

    @Column(name = "post_code", columnDefinition = "VARCHAR(20)", nullable = false)
    lateinit var postCode: String
}