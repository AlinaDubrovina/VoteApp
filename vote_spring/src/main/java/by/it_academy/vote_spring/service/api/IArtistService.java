package by.it_academy.vote_spring.service.api;

import by.it_academy.vote_spring.core.dto.ArtistDTO;
import by.it_academy.vote_spring.core.entity.ArtistEntity;

import java.util.List;

public interface IArtistService{
    void create(ArtistDTO artistDTO);
    void delete(Long id);
    void update(Long id, ArtistDTO artistDTO);
    List<ArtistEntity> readAll();
    ArtistDTO get(Long id);
}
