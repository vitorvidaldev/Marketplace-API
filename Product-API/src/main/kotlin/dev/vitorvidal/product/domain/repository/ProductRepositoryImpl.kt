package dev.vitorvidal.product.domain.repository

import dev.vitorvidal.product.domain.entity.ProductEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Repository
class ProductRepositoryImpl(private val em: EntityManager) : ProductRepositoryCustom {
    override fun findByFilter(productName: String?, page: Pageable): Page<ProductEntity> {
        val builder = em.criteriaBuilder
        val query = builder.createQuery(ProductEntity::class.java)

        val product = query.from(ProductEntity::class.java)
        val predicates: MutableList<Predicate> = ArrayList()

        productNameFilter(productName, predicates, builder, product)

        val countQuery = builder.createQuery(Long::class.java)
        val entity_ = countQuery.from(query.resultType)

        entity_.alias("ProductEntity")

        countQuery.select(builder.count(entity_))
        setQueryRestriction(query, countQuery)
        val totalCount = em.createQuery(countQuery).singleResult

        val where = query.where(*predicates.toTypedArray())

        val results = em.createQuery(where)
            .setFirstResult(page.offset.toInt())
            .setMaxResults(page.pageSize)
            .resultList

        return PageableExecutionUtils.getPage(results, page) { totalCount }
    }

    private fun setQueryRestriction(
        query: CriteriaQuery<ProductEntity>,
        countQuery: CriteriaQuery<Long>
    ) {
        val restriction = query.restriction
        if (restriction != null) {
            countQuery.where(restriction)
        }
    }

    private fun productNameFilter(
        productName: String?,
        predicates: MutableList<Predicate>,
        builder: CriteriaBuilder,
        product: Root<ProductEntity>
    ) {
        if (productName != null) {
            predicates.add(builder.equal(product.get<String>("productName"), "%$productName%"))
        }
    }
}