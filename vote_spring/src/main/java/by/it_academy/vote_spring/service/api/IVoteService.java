package by.it_academy.vote_spring.service.api;

import by.it_academy.vote_spring.core.dto.VoteDTO;

import java.util.List;

public interface IVoteService {
    void save(VoteDTO vote);

    List<VoteDTO> getVotes();
}
