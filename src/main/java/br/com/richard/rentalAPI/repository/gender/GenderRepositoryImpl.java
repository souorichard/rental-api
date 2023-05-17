package br.com.richard.rentalAPI.repository.gender;

import br.com.richard.rentalAPI.model.Gender;
import br.com.richard.rentalAPI.repository.filter.GenderFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
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

public class GenderRepositoryImpl implements GenderRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Gender> filter(GenderFilter genderFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Gender> criteria = builder.createQuery(Gender.class);
        Root<Gender> root = criteria.from(Gender.class);

        Predicate[] predicates = createRestrictions(genderFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("description")));

        TypedQuery<Gender> query = manager.createQuery(criteria);

        return null;
    }

    private Predicate[] createRestrictions(GenderFilter genderFilter, CriteriaBuilder builder, Root<Gender> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(genderFilter.getDescription())) {
            predicates.add(builder.like(builder.lower(root.get("description")), "%" + genderFilter.getDescription().toLowerCase() + "%"));
            return predicates.toArray(new Predicate[predicates.size()]);
        }

        return null;
    }

}
