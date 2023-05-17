package br.com.richard.rentalAPI.repository.actor;

import br.com.richard.rentalAPI.model.Actor;
import br.com.richard.rentalAPI.repository.filter.ActorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActorRepositoryQuery {

    public Page<Actor> filter(ActorFilter actorFilter, Pageable pageable);

}
