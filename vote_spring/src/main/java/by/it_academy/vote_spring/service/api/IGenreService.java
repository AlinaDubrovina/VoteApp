package by.it_academy.vote_spring.service.api;

import by.it_academy.vote_spring.core.dto.GenreDTO;
import by.it_academy.vote_spring.core.entity.GenreEntity;

import java.util.List;

public interface IGenreService{
    void create(GenreDTO genreDTO);
    void delete(Long id);
    void update(Long id, GenreDTO genreDTO);
    List<GenreEntity> readAll();
    GenreDTO get(Long id);
}
