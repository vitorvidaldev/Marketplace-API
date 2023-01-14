package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "user")
open class User {
    @Id
    lateinit var id: UUID

    @Column(name = "full_name", columnDefinition = "VARCHAR(60)", nullable = false)
    lateinit var fullName: String

    @Column(name = "email", columnDefinition = "VARCHAR(60)", nullable = false)
    lateinit var email: String

    @Column(name = "password", columnDefinition = "VARCHAR(60)", nullable = false)
    lateinit var password: String

    @Column(name = "cpf", columnDefinition = "CHAR(11)", nullable = false)
    lateinit var cpf: String

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var address: Address

    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var creationDate: Timestamp

    @Column(name = "last_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    lateinit var lastUpdateDate: Timestamp
}
