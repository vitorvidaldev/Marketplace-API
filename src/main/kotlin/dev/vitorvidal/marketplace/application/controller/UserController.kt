package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.UserService
import dev.vitorvidal.marketplace.domain.vo.LoginVO
import dev.vitorvidal.marketplace.domain.vo.RegisterUserVO
import dev.vitorvidal.marketplace.domain.vo.UserResponseVO
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rest/v1/user")
class UserController(val userService: UserService) {
    @GetMapping("/{userId}")
    fun getUserById(@PathVariable(name = "userId") userId: UUID): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok(userService.getUserById(userId))

    @PostMapping("/login")
    fun loginUser(@RequestBody @Valid loginVO: LoginVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok(userService.loginUser(loginVO))

    @PostMapping
    fun registerUser(@RequestBody @Valid registerUserVO: RegisterUserVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(registerUserVO))

    @PutMapping // TODO patch?
    fun registerUserAddress(): ResponseEntity<UserResponseVO> {

    }

    @PutMapping // TODO patch?
    fun updateUserData(): ResponseEntity<UserResponseVO> {

    }

    @PutMapping // TODO patch?
    fun updateUserPassword(): ResponseEntity<UserResponseVO> {

    }

    @DeleteMapping("/{id}")
    fun deleteUser(): ResponseEntity<Void> {

    }
}