package br.com.richard.rentalAPI.controller;

import br.com.richard.rentalAPI.model.Gender;
import br.com.richard.rentalAPI.model.Movie;
import br.com.richard.rentalAPI.repository.MovieRepository;
import br.com.richard.rentalAPI.repository.filter.GenderFilter;
import br.com.richard.rentalAPI.repository.filter.MovieFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/all")
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @GetMapping()
    public Page<Movie> search(MovieFilter movieFilter, Pageable pageable) {
        return movieRepository.filter(movieFilter, pageable);
    }

}
