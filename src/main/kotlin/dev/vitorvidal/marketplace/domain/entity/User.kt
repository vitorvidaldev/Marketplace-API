package dev.vitorvidal.marketplace.domain.entity

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.sql.Timestamp
import java.util.*

@Entity
@Table(name = "user")
class User(
    @Id
    val id: UUID,
    @Column(name = "full_name", columnDefinition = "VARCHAR(60)", nullable = false)
    val fullName: String,
    @Column(name = "email", columnDefinition = "VARCHAR(60)", nullable = false)
    val email: String,
    @Column(name = "password", columnDefinition = "VARCHAR(60)", nullable = false)
    val password: String,
    @Column(name = "cpf", columnDefinition = "CHAR(11)", nullable = false)
    val cpf: String,
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val creationDate: Timestamp,
    @Column(name = "last_update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    val lastUpdateDate: Timestamp
) {
    @ManyToOne(fetch = FetchType.LAZY) // TODO should this relationship be null?
    lateinit var address: Address

    override fun toString(): String =
        "User(id=$id, fullName='$fullName', email='$email', password='$password', cpf='$cpf', creationDate=$creationDate, lastUpdateDate=$lastUpdateDate)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as User

        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
}
