package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.entity.User
import dev.vitorvidal.marketplace.domain.enum.SearchOperation
import dev.vitorvidal.marketplace.domain.model.SearchCriteria
import dev.vitorvidal.marketplace.domain.repository.UserRepository
import dev.vitorvidal.marketplace.domain.repository.specification.UserSpecification
import dev.vitorvidal.marketplace.domain.vo.*
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.util.*

@Service
class UserService(val userRepository: UserRepository) {
    fun getUserById(userId: UUID): UserResponseVO? {
        val optionalUser = userRepository.findById(userId)
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()
            return UserResponseVO(
                entity.id, entity.fullName, entity.email, entity.creationDate, entity.lastUpdateDate, entity.address
            )
        }
        return null // TODO throw exception; add controller advice
    }

    fun loginUser(loginVO: LoginVO): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun registerUser(registerUserVO: RegisterUserVO): UserResponseVO? {
        val entity = userRepository.save(
            User(
                UUID.randomUUID(),
                registerUserVO.fullName,
                registerUserVO.email,
                registerUserVO.password,
                registerUserVO.cpf,
                Timestamp.from(Instant.now()),
                Timestamp.from(Instant.now())
            )
        )
        return UserResponseVO(
            entity.id,
            entity.fullName,
            entity.email,
            entity.creationDate,
            entity.lastUpdateDate,
            entity.address
        )
    }

    fun deleteUser(userId: UUID): Unit = userRepository.deleteById(userId)

    fun registerUserAddress(registerAddressVO: Any): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun updateUserData(userId: UUID, updateUserDataVO: UpdateUserDataVO): UserResponseVO? {
        val optionalUser = userRepository.findById(userId)
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()

            entity.email = updateUserDataVO.email
            entity.fullName = updateUserDataVO.fullName
            entity.lastUpdateDate = Timestamp.from(Instant.now())
            val updatedEntity = userRepository.save(entity)
            return UserResponseVO(
                updatedEntity.id,
                updatedEntity.fullName,
                updatedEntity.email,
                updatedEntity.creationDate,
                updatedEntity.lastUpdateDate,
                updatedEntity.address
            )
        }
        return null  // TODO throw exception; add controller advice
    }

    fun updateUserPassword(updateUserPasswordVO: UpdateUserPasswordVO): UserResponseVO? {
        val spec = UserSpecification()
        spec.add(SearchCriteria("email", updateUserPasswordVO.email, SearchOperation.EQUAL))
        val optionalUser: Optional<User> = userRepository.findBy(spec) { q -> q.first() }
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()
            entity.password = updateUserPasswordVO.password
            entity.lastUpdateDate = Timestamp.from(Instant.now())
            val updatedEntity = userRepository.save(entity)
            return UserResponseVO(
                updatedEntity.id,
                updatedEntity.fullName,
                updatedEntity.email,
                updatedEntity.creationDate,
                updatedEntity.lastUpdateDate,
                updatedEntity.address
            )
        }
        return null // TODO throw exception; add controller advice
    }
}