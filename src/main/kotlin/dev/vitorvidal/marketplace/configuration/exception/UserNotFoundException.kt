package dev.vitorvidal.marketplace.configuration.exception

class UserNotFoundException(override val message: String) : RuntimeException(message)
