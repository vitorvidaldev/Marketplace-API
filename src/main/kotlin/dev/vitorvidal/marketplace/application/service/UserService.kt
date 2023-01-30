package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.configuration.exception.UserNotFoundException
import dev.vitorvidal.marketplace.domain.entity.User
import dev.vitorvidal.marketplace.domain.enum.SearchOperation
import dev.vitorvidal.marketplace.domain.model.SearchCriteria
import dev.vitorvidal.marketplace.domain.repository.UserRepository
import dev.vitorvidal.marketplace.domain.repository.specification.UserSpecification
import dev.vitorvidal.marketplace.domain.vo.*
import dev.vitorvidal.marketplace.util.Constants.Companion.USER_NOT_FOUND_EXCEPTION_MESSAGE
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.Instant
import java.util.*

@Service
class UserService(val userRepository: UserRepository, val addressService: AddressService) {
    fun getUserById(userId: UUID): UserResponseVO? {
        val optionalUser = userRepository.findById(userId)
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()
            return UserResponseVO(
                entity.id,
                entity.fullName,
                entity.email,
                entity.creationDate,
                entity.lastUpdateDate,
                entity.address?.toAddressVO()
            )
        }
        throw UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE)
    }

    fun loginUser(loginVO: LoginVO): UserResponseVO? {
        val spec = UserSpecification()
        spec.add(SearchCriteria(User::email.name, loginVO.email, SearchOperation.EQUAL))
        spec.add(SearchCriteria(User::password.name, loginVO.password, SearchOperation.EQUAL))
        val optionalUser: Optional<User> = userRepository.findBy(spec) { q -> q.first() }
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()
            return UserResponseVO(
                entity.id,
                entity.fullName,
                entity.email,
                entity.creationDate,
                entity.lastUpdateDate,
                entity.address?.toAddressVO() // TODO fix load bug
            )
        }
        throw UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE)
    }

    fun registerUser(registerUserVO: RegisterUserVO): UserResponseVO = userRepository.save(
        User(
            UUID.randomUUID(),
            registerUserVO.fullName,
            registerUserVO.email,
            registerUserVO.password,
            registerUserVO.cpf,
            Timestamp.from(Instant.now()),
            Timestamp.from(Instant.now())
        )
    ).toUserResponseVO()

    fun deleteUser(userId: UUID): Unit = userRepository.deleteById(userId)

    fun registerUserAddress(userId: UUID, registerAddressVO: RegisterAddressVO): UserResponseVO? {
        val address = addressService.registerUserAddress(registerAddressVO)
        val optionalUser = userRepository.findById(userId)
        if (optionalUser.isPresent) {
            val user = optionalUser.get()
            user.address = address
            user.lastUpdateDate = Timestamp.from(Instant.now())
            userRepository.save(user)
            return user.toUserResponseVO()
        }
        throw UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE)
    }

    fun updateUserData(userId: UUID, updateUserDataVO: UpdateUserDataVO): UserResponseVO? {
        val optionalUser = userRepository.findById(userId)
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()
            entity.email = updateUserDataVO.email
            entity.fullName = updateUserDataVO.fullName
            entity.lastUpdateDate = Timestamp.from(Instant.now())
            val updatedEntity = userRepository.save(entity)
            return updatedEntity.toUserResponseVO()
        }
        throw UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE)
    }

    fun updateUserPassword(updateUserPasswordVO: UpdateUserPasswordVO): UserResponseVO? {
        val spec = UserSpecification()
        spec.add(SearchCriteria(User::email.name, updateUserPasswordVO.email, SearchOperation.EQUAL))
        val optionalUser: Optional<User> = userRepository.findBy(spec) { q -> q.first() }
        if (optionalUser.isPresent) {
            val entity = optionalUser.get()
            entity.password = updateUserPasswordVO.password
            entity.lastUpdateDate = Timestamp.from(Instant.now())
            val updatedEntity = userRepository.save(entity)
            return updatedEntity.toUserResponseVO()
        }
        throw UserNotFoundException(USER_NOT_FOUND_EXCEPTION_MESSAGE)
    }
}