package br.com.richard.rentalAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nameactor;

    @JsonIgnore
    @OneToMany(mappedBy = "actor")
    private List<Movie> movieactor = new ArrayList<>();

}
