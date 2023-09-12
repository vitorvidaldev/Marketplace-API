package dev.vitorvidal.marketplace.application.controller

import dev.vitorvidal.marketplace.application.service.ShoppingCartService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rest/v1/shopping-cart")
class ShoppingCartController(val shoppingCartService: ShoppingCartService) {

}