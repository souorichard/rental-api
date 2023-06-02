package br.com.richard.rentalAPI.repository.movie;

import br.com.richard.rentalAPI.model.Movie;
import br.com.richard.rentalAPI.repository.filter.MovieFilter;
import br.com.richard.rentalAPI.repository.projections.MovieDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieRepositoryQuery {

    public Page<MovieDto> filter(MovieFilter movieFilter, Pageable pageable);

}
