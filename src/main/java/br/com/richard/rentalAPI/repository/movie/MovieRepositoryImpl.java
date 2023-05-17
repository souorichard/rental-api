package br.com.richard.rentalAPI.repository.movie;

import br.com.richard.rentalAPI.model.Movie;
import br.com.richard.rentalAPI.repository.filter.MovieFilter;
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

public class MovieRepositoryImpl implements MovieRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Movie> filter(MovieFilter movieFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteria = builder.createQuery(Movie.class);
        Root<Movie> root = criteria.from(Movie.class);

        Predicate[] predicates = createRestrictions(movieFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("namemovie")));

        TypedQuery<Movie> query = manager.createQuery(criteria);

        return null;
    }

    private Predicate[] createRestrictions(MovieFilter movieFilter, CriteriaBuilder builder, Root<Movie> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(movieFilter.getNamemovie())) {
            predicates.add(builder.like(builder.lower(root.get("namemovie")), "%" + movieFilter.getNamemovie().toLowerCase() + "%"));
            return predicates.toArray(new Predicate[predicates.size()]);
        }

        return null;
    }

}
