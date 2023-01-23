package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.UserService
import dev.vitorvidal.marketplace.domain.vo.*
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/rest/v1/user")
class UserController(val userService: UserService) {
    @GetMapping
    fun getUserById(@RequestHeader(name = "userId") userId: UUID): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok(userService.getUserById(userId))

    @PostMapping("/login")
    fun loginUser(@RequestBody @Valid loginVO: LoginVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok(userService.loginUser(loginVO))

    @PostMapping
    fun registerUser(@RequestBody @Valid registerUserVO: RegisterUserVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(registerUserVO))

    @PutMapping("/address")
    fun registerUserAddress(
        @RequestHeader(name = "userId") userId: UUID,
        @RequestBody @Valid registerAddressVO: RegisterAddressVO
    ): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok().body(userService.registerUserAddress(userId, registerAddressVO))

    @PutMapping("/data")
    fun updateUserData(
        @RequestHeader(name = "userId") userId: UUID,
        @RequestBody @Valid updateUserDataVO: UpdateUserDataVO
    ): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok().body(userService.updateUserData(userId, updateUserDataVO))

    @PutMapping("/password")
    fun updateUserPassword(@RequestBody @Valid updateUserPasswordVO: UpdateUserPasswordVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok().body(userService.updateUserPassword(updateUserPasswordVO))

    @DeleteMapping
    fun deleteUser(@RequestHeader(name = "userId") userId: UUID): ResponseEntity<Void> {
        userService.deleteUser(userId)
        return ResponseEntity.noContent().build()
    }
}