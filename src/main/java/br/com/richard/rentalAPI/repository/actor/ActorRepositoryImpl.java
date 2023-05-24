package br.com.richard.rentalAPI.repository.actor;

import br.com.richard.rentalAPI.model.Actor;
import br.com.richard.rentalAPI.model.Gender;
import br.com.richard.rentalAPI.repository.filter.ActorFilter;
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

public class ActorRepositoryImpl implements ActorRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Actor> filter(ActorFilter actorFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Actor> criteria = builder.createQuery(Actor.class);
        Root<Actor> root = criteria.from(Actor.class);

        Predicate[] predicates = createRestrictions(actorFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nameactor")));

        TypedQuery<Actor> query = manager.createQuery(criteria);
        addRestrictionsOfPagination(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(actorFilter));
    }

    private Long total(ActorFilter actorFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Actor> root = criteria.from(Actor.class);

        Predicate[] predicates = createRestrictions(actorFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nameactor")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void addRestrictionsOfPagination(TypedQuery<Actor> query, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
        int totalRecordPerPage = pageable.getPageSize();
        int primaryRegisterOfPage = currentPage * totalRecordPerPage;

        query.setFirstResult(primaryRegisterOfPage);
        query.setMaxResults(totalRecordPerPage);
    }

    private Predicate[] createRestrictions(ActorFilter actorFilter, CriteriaBuilder builder, Root<Actor> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(actorFilter.getNameactor())) {
            predicates.add(builder.like(builder.lower(root.get("nameactor")), "%" + actorFilter.getNameactor().toLowerCase() + "%"));
            return predicates.toArray(new Predicate[predicates.size()]);
        }

        return null;
    }

}
