package br.com.richard.rentalAPI.repository.gender;

import br.com.richard.rentalAPI.model.Gender;
import br.com.richard.rentalAPI.repository.filter.GenderFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenderRepositoryQuery {

  public Page<Gender> filter(GenderFilter genderFilter, Pageable pageable);

}
