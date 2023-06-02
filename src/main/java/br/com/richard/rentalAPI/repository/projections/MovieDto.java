package br.com.richard.rentalAPI.repository.projections;

public class MovieDto {

    private Long id;

    private String namemovie;

    private String description; // nome do Gênero

    private String nameactor; // nome do Ator

    public MovieDto(Long id, String namemovie, String description, String nameactor) {
        this.id = id;
        this.namemovie = namemovie;
        this.description = description;
        this.nameactor = nameactor;
    }
}
