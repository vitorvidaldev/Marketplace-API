package dev.vitorvidal.marketplace.domain.model

import dev.vitorvidal.marketplace.domain.enum.SearchOperation

data class SearchCriteria(
    val key: String,
    val value: Any,
    val searchOperation: SearchOperation
)
