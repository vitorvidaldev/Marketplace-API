package dev.vitorvidal.marketplace.application.service

import dev.vitorvidal.marketplace.domain.repository.UserRepository
import dev.vitorvidal.marketplace.domain.vo.LoginVO
import dev.vitorvidal.marketplace.domain.vo.RegisterUserVO
import dev.vitorvidal.marketplace.domain.vo.UserResponseVO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository) {
    fun getUserById(userId: UUID): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun loginUser(loginVO: LoginVO): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun registerUser(registerUserVO: RegisterUserVO): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun deleteUser(): ResponseEntity<Void> {
        TODO("Not yet implemented")
    }

    fun registerUserAddress(registerAddressVO: Any): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun updateUserData(updateUserDataVO: Any): UserResponseVO? {
        TODO("Not yet implemented")
    }

    fun updateUserPassword(updateUserPasswordVO: Any): UserResponseVO? {
        TODO("Not yet implemented")
    }
}