package by.it_academy.vote_spring.dao.api;

import by.it_academy.vote_spring.core.entity.VoteEntity;

import java.util.List;

public interface IVoteDAO{
    List<VoteEntity> getAll();

    void save(VoteEntity votes);
}
