package dev.vitorvidal.marketplace.domain.enum

enum class SearchOperation {
    GREATER_THAN,
    LESS_THAN,
    GREATER_THAN_EQUAL,
    LESS_THAN_EQUAL,
    NOT_EQUAL,
    EQUAL,
    LIKE,
    LIKE_START,
    LIKE_END,
    IN,
    NOT_IN
}