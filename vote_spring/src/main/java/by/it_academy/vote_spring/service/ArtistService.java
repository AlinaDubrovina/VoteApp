package by.it_academy.vote_spring.service;

import by.it_academy.vote_spring.core.dto.ArtistDTO;
import by.it_academy.vote_spring.core.entity.ArtistEntity;
import by.it_academy.vote_spring.dao.api.IArtistDAO;
import by.it_academy.vote_spring.service.api.IArtistService;

import java.util.List;

public class ArtistService implements IArtistService {
    private final IArtistDAO artistDAO;

    public ArtistService(IArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    @Override
    public void create(ArtistDTO artistDTO) {
        artistDAO.create(new ArtistEntity(artistDTO.getName()));
    }

    @Override
    public List<ArtistEntity> readAll() {
        return artistDAO.readAll();
    }

    @Override
    public void update(Long id, ArtistDTO artistDTO) {
        String name = artistDTO.getName();
        artistDAO.update(new ArtistEntity(id, name));
    }

    @Override
    public ArtistDTO get(Long id) {
        ArtistEntity artist = artistDAO.get(id);
        return new ArtistDTO(artist.getId(), artist.getName());
    }

    @Override
    public void delete(Long id) {
        artistDAO.delete(id);
    }
}
