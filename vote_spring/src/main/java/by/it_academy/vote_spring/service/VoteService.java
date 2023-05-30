package by.it_academy.vote_spring.service;

import by.it_academy.vote_spring.core.dto.VoteDTO;
import by.it_academy.vote_spring.core.entity.ArtistEntity;
import by.it_academy.vote_spring.core.entity.GenreEntity;
import by.it_academy.vote_spring.core.entity.VoteEntity;
import by.it_academy.vote_spring.dao.api.IVoteDAO;
import by.it_academy.vote_spring.service.api.IArtistService;
import by.it_academy.vote_spring.service.api.IGenreService;
import by.it_academy.vote_spring.service.api.IVoteService;

import java.util.List;
import java.util.stream.Collectors;

public class VoteService implements IVoteService {
    private final IVoteDAO voteDAO;
    private final IArtistService artistService;
    private final IGenreService genreService;

    public VoteService(IVoteDAO voteDAO, IArtistService artistService, IGenreService genreService) {
        this.voteDAO = voteDAO;
        this.artistService = artistService;
        this.genreService = genreService;
    }

    @Override
    public void save(VoteDTO vote) {
        VoteEntity voteEntity = convertToVoteEntity(vote);
        voteDAO.save(voteEntity);
    }

    @Override
    public List<VoteDTO> getVotes() {
        return convertFromVoteEntityList(voteDAO.getAll());
    }

    private VoteEntity convertToVoteEntity(VoteDTO voteDTO) {
        return new VoteEntity(
                new ArtistEntity(voteDTO.getArtistId()),
                voteDTO.getAbout(),
                voteDTO.getGenreIds().stream().map(GenreEntity::new).collect(Collectors.toList())
        );
    }

    private List<VoteDTO> convertFromVoteEntityList(List<VoteEntity> voteEntities) {
        return voteEntities.stream()
                .map(vote -> new VoteDTO(
                        vote.getArtistId().getId(),
                        vote.getGenreIds().stream().map(GenreEntity::getId).collect(Collectors.toList()),
                        vote.getAbout()))
                .collect(Collectors.toList());
    }
}
