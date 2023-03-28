package br.com.richard.rentalAPI.controller;

import br.com.richard.rentalAPI.model.Actor;
import br.com.richard.rentalAPI.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/all")
    public List<Actor> list() {
        return actorRepository.findAll();
    }

}
