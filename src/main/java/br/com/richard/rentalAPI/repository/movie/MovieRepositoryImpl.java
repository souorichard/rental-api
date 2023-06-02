package br.com.richard.rentalAPI.repository.movie;

import br.com.richard.rentalAPI.repository.filter.MovieFilter;
import br.com.richard.rentalAPI.repository.projections.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MovieRepositoryImpl implements MovieRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<MovieDto> filter(MovieFilter movieFilter, Pageable pageable) {
        return null;
    }

}
