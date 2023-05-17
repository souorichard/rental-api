package br.com.richard.rentalAPI.repository.movie;

import br.com.richard.rentalAPI.model.Movie;
import br.com.richard.rentalAPI.repository.filter.MovieFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieRepositoryQuery {

    public Page<Movie> filter(MovieFilter movieFilter, Pageable pageable);

}
