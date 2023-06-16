package br.com.richard.rentalAPI.repository.projections;

import lombok.Data;

@Data
public class MovieDto {

  private Long id; // id do Filme

  private String namemovie; // nome do Filme

  private String description; // nome do Gênero

  private String nameactor; // nome do Ator

  public MovieDto(Long id, String namemovie, String description, String nameactor) {
    this.id = id;
    this.namemovie = namemovie;
    this.description = description;
    this.nameactor = nameactor;
  }
}
