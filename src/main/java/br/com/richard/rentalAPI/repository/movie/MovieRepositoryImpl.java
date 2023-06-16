package br.com.richard.rentalAPI.repository.movie;

import br.com.richard.rentalAPI.model.Gender;
import br.com.richard.rentalAPI.model.Movie;
import br.com.richard.rentalAPI.repository.filter.MovieFilter;
import br.com.richard.rentalAPI.repository.projections.MovieDto;
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

public class MovieRepositoryImpl implements MovieRepositoryQuery {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public Page<MovieDto> filter(MovieFilter movieFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<MovieDto> criteria = builder.createQuery(MovieDto.class);
    Root<Movie> root = criteria.from(Movie.class);

    criteria.select(builder.construct(MovieDto.class, root.get("id"), root.get("namemovie"), root.get("gender").get("description"), root.get("actor").get("nameactor")));

    Predicate[] predicates = createRestrictions(movieFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("namemovie")));

    TypedQuery<MovieDto> query = manager.createQuery(criteria);
    addRestrictionsOfPagination(query, pageable);

    return new PageImpl<>(query.getResultList(), pageable, total(movieFilter));
  }

  private Long total(MovieFilter movieFilter) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Movie> root = criteria.from(Movie.class);

    Predicate[] predicates = createRestrictions(movieFilter, builder, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("namemovie")));

    criteria.select(builder.count(root));

    return manager.createQuery(criteria).getSingleResult();
  }

  private void addRestrictionsOfPagination(TypedQuery<?> query, Pageable pageable) {
    int currentPage = pageable.getPageNumber();
    int totalRecordPerPage = pageable.getPageSize();
    int primaryRegisterOfPage = currentPage * totalRecordPerPage;

    query.setFirstResult(primaryRegisterOfPage);
    query.setMaxResults(totalRecordPerPage);
  }

  private Predicate[] createRestrictions(MovieFilter movieFilter, CriteriaBuilder builder, Root<Movie> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(movieFilter.getNamemovie())) {
      predicates.add(builder.like(builder.lower(root.get("namemovie")), "%" + movieFilter.getNamemovie().toLowerCase() + "%"));
    }

    if (!StringUtils.isEmpty(movieFilter.getDescription())) {
      predicates.add(builder.like(builder.lower(root.get("gender").get("description")), "%" + movieFilter.getNamemovie().toLowerCase() + "%"));
    }

    if (!StringUtils.isEmpty(movieFilter.getNameactor())) {
      predicates.add(builder.like(builder.lower(root.get("actor").get("nameactor")), "%" + movieFilter.getNamemovie().toLowerCase() + "%"));
    }

    return predicates.toArray(new Predicate[predicates.size()]);
  }

}
