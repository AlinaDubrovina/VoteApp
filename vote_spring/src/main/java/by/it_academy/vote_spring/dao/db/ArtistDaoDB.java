package by.it_academy.vote_spring.dao.db;

import by.it_academy.vote_spring.core.entity.ArtistEntity;
import by.it_academy.vote_spring.dao.api.IArtistDAO;
import by.it_academy.vote_spring.dao.util.ConnectionManager;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistDaoDB implements IArtistDAO {
    private final ConnectionManager connectionManager;

    public ArtistDaoDB(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(ArtistEntity artistEntity) {
        EntityManager artistEntityManager = connectionManager.open();
            artistEntityManager.getTransaction().begin();
            artistEntityManager.persist(artistEntity);
            artistEntityManager.getTransaction().commit();
            artistEntityManager.close();
    }


    @Override
    public ArtistEntity get(Long id) {
        EntityManager artistEntityManager = connectionManager.open();
            artistEntityManager.getTransaction().begin();
            artistEntityManager.createNativeQuery("SET TRANSACTION READ ONLY;").executeUpdate();

            ArtistEntity artistEntity = artistEntityManager.find(ArtistEntity.class, id);

            artistEntityManager.getTransaction().commit();

        return artistEntity;
    }

    @Override
       public List<ArtistEntity> readAll() {
        EntityManager artistEntityManager = connectionManager.open();

        artistEntityManager.getTransaction().begin();
        List<ArtistEntity> resultList = artistEntityManager.createQuery("FROM ArtistEntity", ArtistEntity.class).getResultList();
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
        return resultList;
    }

    @Override
    public void delete(Long id) {
        EntityManager artistEntityManager = connectionManager.open();

        artistEntityManager.getTransaction().begin();
        ArtistEntity artistToRemove = artistEntityManager.find(ArtistEntity.class, id);
        artistEntityManager.remove(artistToRemove);
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
    }

    @Override
    public void update(ArtistEntity artistEntity) {
        EntityManager artistEntityManager = connectionManager.open();

        artistEntityManager.getTransaction().begin();
        artistEntityManager.merge(artistEntity);
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
    }
}

