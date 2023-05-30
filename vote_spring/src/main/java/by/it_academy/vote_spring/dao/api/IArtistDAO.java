package by.it_academy.vote_spring.dao.api;

import by.it_academy.vote_spring.core.entity.ArtistEntity;

import java.util.List;

public interface IArtistDAO {
    List<ArtistEntity> readAll();
    void create(ArtistEntity artist);

    ArtistEntity get(Long id);

    void update(ArtistEntity artist);

    void delete(Long id);
}
