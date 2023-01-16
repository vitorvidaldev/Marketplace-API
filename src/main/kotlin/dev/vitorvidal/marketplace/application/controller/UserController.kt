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
    @GetMapping("/{userId}")
    fun getUserById(@PathVariable(name = "userId") userId: UUID): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok(userService.getUserById(userId))

    @PostMapping("/login")
    fun loginUser(@RequestBody @Valid loginVO: LoginVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok(userService.loginUser(loginVO))

    @PostMapping
    fun registerUser(@RequestBody @Valid registerUserVO: RegisterUserVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(registerUserVO))

    @PutMapping("/address") // TODO patch?
    fun registerUserAddress(
        @RequestBody @Valid registerAddressVO: RegisterAddressVO
    ): ResponseEntity<UserResponseVO> = ResponseEntity.ok().body(userService.registerUserAddress(registerAddressVO))

    @PutMapping("/data") // TODO patch?
    fun updateUserData(@RequestBody @Valid updateUserDataVO: UpdateUserDataVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok().body(userService.updateUserData(updateUserDataVO))

    @PutMapping("/password") // TODO patch?
    fun updateUserPassword(@RequestBody @Valid updateUserPasswordVO: UpdateUserPasswordVO): ResponseEntity<UserResponseVO> =
        ResponseEntity.ok().body(userService.updateUserPassword(updateUserPasswordVO))

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable(name = "userId") userId: UUID): ResponseEntity<Void> = userService.deleteUser()
}