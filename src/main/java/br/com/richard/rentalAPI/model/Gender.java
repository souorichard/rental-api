package br.com.richard.rentalAPI.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String namegender;

    @ManyToOne
    @JoinColumn(name = "idmovie")
    private Movie idmovie;

}
