package dev.vitorvidal.marketplace.configuration.exception

class ProductNotFoundException(override val message: String) : RuntimeException(message)