package dev.vitorvidal.marketplace.util

import dev.vitorvidal.marketplace.domain.enum.SearchOperation.*
import dev.vitorvidal.marketplace.domain.model.SearchCriteria
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root

class SpecificationUtils {
    fun <T> getPredicate(
        criteriaBuilder: CriteriaBuilder,
        root: Root<T>,
        criteriaList: MutableList<SearchCriteria>
    ): Predicate? {
        val predicates: MutableList<Predicate> = ArrayList()
        for (criteria in criteriaList) {
            when (criteria.searchOperation) {
                GREATER_THAN -> predicates.add(
                    criteriaBuilder.greaterThan(
                        root.get(criteria.key),
                        criteria.value.toString()
                    )
                )

                LESS_THAN -> predicates.add(
                    criteriaBuilder.lessThan(
                        root.get(criteria.key),
                        criteria.value.toString()
                    )
                )

                GREATER_THAN_EQUAL -> predicates.add(
                    criteriaBuilder.greaterThanOrEqualTo(
                        root.get(criteria.key),
                        criteria.value.toString()
                    )
                )

                LESS_THAN_EQUAL -> predicates.add(
                    criteriaBuilder.lessThanOrEqualTo(
                        root.get(criteria.key),
                        criteria.value.toString()
                    )
                )

                NOT_EQUAL -> predicates.add(
                    criteriaBuilder.notEqual(
                        root.get<Any>(criteria.key),
                        criteria.value
                    )
                )

                EQUAL -> predicates.add(
                    criteriaBuilder.equal(
                        root.get<Any>(criteria.key),
                        criteria.value
                    )
                )

                LIKE -> predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get(criteria.key)),
                        "%" + criteria.value.toString().lowercase() + "%"
                    )
                )

                LIKE_END -> predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get(criteria.key)),
                        criteria.value.toString().lowercase() + "%"
                    )
                )

                LIKE_START -> predicates.add(
                    criteriaBuilder.like(
                        criteriaBuilder.lower(root.get(criteria.key)),
                        "%" + criteria.value.toString().lowercase()
                    )
                )

                IN -> predicates.add(
                    criteriaBuilder.`in`(root.get<Any>(criteria.key)).value(criteria.value)
                )

                NOT_IN -> predicates.add(
                    criteriaBuilder.not(root.get(criteria.key)).`in`(criteria.value)
                )
            }
        }
        return criteriaBuilder.and(*predicates.toTypedArray())
    }
}