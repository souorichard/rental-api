package br.com.richard.rentalAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nameactor;

    @ManyToOne
    @JoinColumn(name = "idmovie")
    private Movie idmovie;

}
