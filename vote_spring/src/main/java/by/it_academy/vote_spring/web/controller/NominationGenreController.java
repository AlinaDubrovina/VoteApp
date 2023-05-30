package by.it_academy.vote_spring.web.controller;

import by.it_academy.vote_spring.core.dto.ArtistDTO;
import by.it_academy.vote_spring.core.dto.GenreDTO;
import by.it_academy.vote_spring.core.entity.GenreEntity;
import by.it_academy.vote_spring.service.api.IGenreService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class NominationGenreController {
    private final IGenreService genreService;

    public NominationGenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<GenreEntity> getList() {
       return genreService.readAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GenreDTO getById(@PathVariable("id") Long id){
        return genreService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody GenreDTO genre) {
        genreService.create(genre);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id,
                       @RequestBody GenreDTO genre) {
        genreService.update(id, genre);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long genreId) {
        genreService.delete(genreId);
    }
}