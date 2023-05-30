package by.it_academy.vote_spring.dao.db;

import by.it_academy.vote_spring.core.entity.ArtistEntity;
import by.it_academy.vote_spring.core.entity.GenreEntity;
import by.it_academy.vote_spring.core.entity.VoteEntity;
import by.it_academy.vote_spring.dao.api.IVoteDAO;
import by.it_academy.vote_spring.dao.util.ConnectionManager;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VoteDaoDB implements IVoteDAO {
    private final ConnectionManager connectionManager;

    public VoteDaoDB(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public List<VoteEntity> getAll() {
        List<VoteEntity> voteEntities;
        EntityManager voteEntityManager = connectionManager.open();
        voteEntityManager.getTransaction().begin();

        CriteriaBuilder cb = voteEntityManager.getCriteriaBuilder();
        CriteriaQuery<VoteEntity> voteQuery = cb.createQuery(VoteEntity.class);

        Root<VoteEntity> from = voteQuery.from(VoteEntity.class);
        from.fetch("genreIds", JoinType.INNER);
        CriteriaQuery<VoteEntity> finalVoteQuery = voteQuery.select(from);

        voteEntities = voteEntityManager.createQuery(finalVoteQuery)
                .getResultStream()
                .distinct()
                .collect(Collectors.toList());
        voteEntityManager.getTransaction().commit();

        return voteEntities;
    }

    @Override
    public void save(VoteEntity vote) {
        EntityManager voteEntityManager = connectionManager.open();
        voteEntityManager.getTransaction().begin();

        ArtistEntity artist = voteEntityManager.find(ArtistEntity.class, vote.getArtistId().getId());
        vote.setArtistId(artist);

        List<GenreEntity> genres = vote.getGenreIds();
        vote.setGenreIds(new ArrayList<>());
        genres.stream()
                .map(GenreEntity::getId)
                .forEach(id -> vote.getGenreIds().add(voteEntityManager.find(GenreEntity.class, id)));
        voteEntityManager.persist(vote);
        voteEntityManager.getTransaction().commit();
        voteEntityManager.close();
    }
}