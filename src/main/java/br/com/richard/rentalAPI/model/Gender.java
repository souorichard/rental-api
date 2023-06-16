package br.com.richard.rentalAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "gender")
public class Gender {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String description;

  @JsonIgnore
  @OneToMany(mappedBy = "gender")
  private List<Movie> moviegender = new ArrayList<>();

}
