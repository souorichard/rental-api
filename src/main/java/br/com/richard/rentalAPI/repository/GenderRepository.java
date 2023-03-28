package br.com.richard.rentalAPI.repository;

import br.com.richard.rentalAPI.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
