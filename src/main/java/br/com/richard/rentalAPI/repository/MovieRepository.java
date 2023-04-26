package br.com.richard.rentalAPI.repository;

import br.com.richard.rentalAPI.model.Movie;
import br.com.richard.rentalAPI.repository.movie.MovieRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, MovieRepositoryQuery {
}
