package br.com.rafael.moneyapi.repository.launch;

import br.com.rafael.moneyapi.model.Launch;
import br.com.rafael.moneyapi.model.Launch_;
import br.com.rafael.moneyapi.repository.filter.LaunchFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LaunchRepositoryImpl implements LaunchRepositoryQuery {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Launch> filter(LaunchFilter launchFilter, Pageable pageable) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Launch> criteriaQuery = builder.createQuery(Launch.class);
        Root<Launch> root = criteriaQuery.from(Launch.class);

        //criar as restrições
        Predicate[] predicates = createRestrictions(launchFilter, builder, root);
        criteriaQuery.where(predicates);

        TypedQuery<Launch> query = entityManager.createQuery(criteriaQuery);
        addPaginationRestrictions(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, total(launchFilter));
    }

    private Long total(LaunchFilter launchFilter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
        Root<Launch> root = criteriaQuery.from(Launch.class);

        Predicate[] predicates = createRestrictions(launchFilter, builder, root);
        criteriaQuery.where(predicates);
        criteriaQuery.select(builder.count(root));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    private void addPaginationRestrictions(TypedQuery<Launch> query, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
        int totalRecordsPerPage = pageable.getPageSize();
        int firstRecord = currentPage * totalRecordsPerPage;

        query.setFirstResult(firstRecord);
        query.setMaxResults(totalRecordsPerPage);
    }

    private Predicate[] createRestrictions(LaunchFilter launchFilter, CriteriaBuilder builder, Root<Launch> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(launchFilter.getDescription())) {
            predicates.add(builder.like(
                    builder.lower(root.get(Launch_.DESCRIPTION)),
                    "%" + launchFilter.getDescription().toLowerCase(Locale.ROOT) + "%"
            ));
        }
        if (launchFilter.getDueDate() != null) {
            predicates.add(builder.lessThanOrEqualTo(
                    root.get(Launch_.DUE_DATE), launchFilter.getDueDate()
            ));
        }
        if (launchFilter.getPaymentDate() != null) {
            predicates.add(
                    builder.greaterThanOrEqualTo(
                            root.get(Launch_.PAYMENT_DATE), launchFilter.getPaymentDate()));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
