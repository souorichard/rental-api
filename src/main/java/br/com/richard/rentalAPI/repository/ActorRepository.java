package br.com.richard.rentalAPI.repository;

import br.com.richard.rentalAPI.model.Actor;
import br.com.richard.rentalAPI.repository.actor.ActorRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>, ActorRepositoryQuery {
}
