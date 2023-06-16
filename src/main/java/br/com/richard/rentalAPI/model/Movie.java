package br.com.richard.rentalAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String namemovie;

  @ManyToOne
  @JoinColumn(name = "idactor")
  private Actor actor;

  @ManyToOne
  @JoinColumn(name = "idgender")
  private Gender gender;

}
