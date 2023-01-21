package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.UserService
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldNotBe
import io.mockk.mockk

// TODO fix test execution; its running junit instead of kotest
class UserControllerTest : FunSpec({
    val userService = mockk<UserService>()

    val userController = UserController(userService)

    test("should instantiate object correctly") {
        userController shouldNotBe null
    }
})