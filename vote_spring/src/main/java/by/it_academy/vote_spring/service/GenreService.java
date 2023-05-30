package by.it_academy.vote_spring.service;

import by.it_academy.vote_spring.core.dto.GenreDTO;
import by.it_academy.vote_spring.core.entity.GenreEntity;
import by.it_academy.vote_spring.dao.api.IGenreDAO;
import by.it_academy.vote_spring.service.api.IGenreService;

import java.util.List;

public class GenreService implements IGenreService {
    private final IGenreDAO genreDAO;

    public GenreService(IGenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Override
    public void create(GenreDTO genreDTO) {
        genreDAO.create(new GenreEntity(genreDTO.getName()));
    }

    @Override
    public List<GenreEntity> readAll() {
        return genreDAO.readAll();
    }

    @Override
    public GenreDTO get(Long id) {
        GenreEntity genre = genreDAO.get(id);
        return new GenreDTO(genre);
    }

    @Override
    public void update(Long id, GenreDTO genreDTO){
       String name = genreDTO.getName();
        genreDAO.update(new GenreEntity(id, name));
    }

    @Override
    public void delete(Long id) {;
        genreDAO.delete(id);
    }
}