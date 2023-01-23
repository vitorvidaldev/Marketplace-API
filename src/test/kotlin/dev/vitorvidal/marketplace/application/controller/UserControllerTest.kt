package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.UserService
import dev.vitorvidal.marketplace.domain.vo.UserResponseVO
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.sql.Timestamp
import java.time.Instant
import java.util.*

// TODO fix test execution; its running junit instead of kotest
class UserControllerTest : FunSpec({
    val userService = mockk<UserService>()
    val userController = UserController(userService)

    // TODO build factory for test case objects
    val userId = UUID.randomUUID()
    val fullName = "user full name"
    val email = "test@gmail.com"
    val creationDate = Timestamp.from(Instant.now())
    val lastUpdatedDate = Timestamp.from(Instant.now())

    val userResponseVO = UserResponseVO(
        userId, fullName, email, creationDate, lastUpdatedDate, null
    )

    test("should instantiate object correctly") {
        userController shouldNotBe null
    }

    test("should get user by id correctly") {
        every { userService.getUserById(userId) }.returns(userResponseVO)

        val response = userController.getUserById(userId)

        response shouldNotBe null
        response.statusCode.value() shouldBe 200
        response.body shouldBe userResponseVO

        verify(exactly = 1) { userService.getUserById(userId) }
    }
})