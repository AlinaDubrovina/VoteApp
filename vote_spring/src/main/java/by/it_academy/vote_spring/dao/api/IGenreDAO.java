package by.it_academy.vote_spring.dao.api;

import by.it_academy.vote_spring.core.entity.GenreEntity;
import java.util.List;

public interface IGenreDAO {
    List<GenreEntity> readAll();
    void create(GenreEntity genre);

    GenreEntity get(Long id);

    void update(GenreEntity genre);

    void delete(Long id);
}
