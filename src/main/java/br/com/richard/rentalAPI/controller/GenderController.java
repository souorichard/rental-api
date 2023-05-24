package br.com.richard.rentalAPI.controller;

import br.com.richard.rentalAPI.model.Gender;
import br.com.richard.rentalAPI.repository.GenderRepository;
import br.com.richard.rentalAPI.repository.filter.GenderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {

    @Autowired
    private GenderRepository genderRepository;

    @GetMapping("/all")
    public List<Gender> list() {
        return genderRepository.findAll();
    }

    @GetMapping()
    public Page<Gender> search(GenderFilter genderFilter, Pageable pageable) {
        return genderRepository.filter(genderFilter, pageable);
    }

}
