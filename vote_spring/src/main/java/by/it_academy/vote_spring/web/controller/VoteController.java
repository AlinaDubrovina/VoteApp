package by.it_academy.vote_spring.web.controller;

import by.it_academy.vote_spring.core.dto.VoteDTO;
import by.it_academy.vote_spring.service.api.IVoteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/vote")
public class VoteController {

    private final IVoteService voteService;

    public VoteController(IVoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody VoteDTO vote) {
        voteService.save(vote);
    }
}

