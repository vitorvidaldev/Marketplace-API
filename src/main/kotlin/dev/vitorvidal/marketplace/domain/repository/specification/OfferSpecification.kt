package dev.vitorvidal.marketplace.domain.repository.specification

import dev.vitorvidal.marketplace.domain.entity.Offer
import dev.vitorvidal.marketplace.domain.model.SearchCriteria
import dev.vitorvidal.marketplace.util.SpecificationUtils
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

class OfferSpecification : Specification<Offer> {
    private val utils = SpecificationUtils()
    private val criteriaList = mutableListOf<SearchCriteria>()

    fun add(criteria: SearchCriteria) {
        criteriaList.add(criteria)
    }

    override fun toPredicate(root: Root<Offer>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate? =
        utils.getPredicate(criteriaBuilder, root, criteriaList)
}