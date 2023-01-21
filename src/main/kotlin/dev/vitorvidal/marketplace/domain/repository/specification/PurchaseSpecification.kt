package dev.vitorvidal.marketplace.domain.repository.specification

import dev.vitorvidal.marketplace.domain.entity.Purchase
import dev.vitorvidal.marketplace.domain.model.SearchCriteria
import dev.vitorvidal.marketplace.util.SpecificationUtils
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

class PurchaseSpecification : Specification<Purchase> {
    private val criteriaList = mutableListOf<SearchCriteria>()
    private val utils = SpecificationUtils()

    fun add(criteria: SearchCriteria) {
        criteriaList.add(criteria)
    }

    override fun toPredicate(
        root: Root<Purchase>,
        query: CriteriaQuery<*>,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? = utils.getPredicate(criteriaBuilder, root, criteriaList)
}