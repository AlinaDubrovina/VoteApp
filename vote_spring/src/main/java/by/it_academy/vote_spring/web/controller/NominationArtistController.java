package by.it_academy.vote_spring.web.controller;

import by.it_academy.vote_spring.core.dto.ArtistDTO;
import by.it_academy.vote_spring.core.entity.ArtistEntity;
import by.it_academy.vote_spring.service.api.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class NominationArtistController {
    private final IArtistService artistService;

    public NominationArtistController(IArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ArtistEntity> getList (){
        return artistService.readAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create (@RequestBody ArtistDTO artist){;
        artistService.create(artist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id,
                       @RequestBody ArtistDTO artist) {
        artistService.update(id, artist);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ArtistDTO getById(@PathVariable("id") Long id){
        return artistService.get(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        artistService.delete(id);
    }
}
