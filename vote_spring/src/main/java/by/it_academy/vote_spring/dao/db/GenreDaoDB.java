package by.it_academy.vote_spring.dao.db;

import by.it_academy.vote_spring.core.entity.GenreEntity;
import by.it_academy.vote_spring.dao.api.IGenreDAO;
import by.it_academy.vote_spring.dao.util.ConnectionManager;

import javax.persistence.EntityManager;
import java.util.List;

public class GenreDaoDB implements IGenreDAO {
    private final ConnectionManager connectionManager;

    public GenreDaoDB(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public void create(GenreEntity genreEntity) {
        EntityManager genreEntityManager = connectionManager.open();
        try {
            genreEntityManager.getTransaction().begin();
            genreEntityManager.persist(genreEntity);
            genreEntityManager.getTransaction().commit();
            genreEntityManager.close();
        } catch (Exception e){
            throw new RuntimeException("Create method exception" + e);
        } finally {
            genreEntityManager.close();
        }
    }

    @Override
    public GenreEntity get(Long id) {
        EntityManager genreEntityManager = connectionManager.open();
            genreEntityManager.getTransaction().begin();
            genreEntityManager.createNativeQuery("SET TRANSACTION READ ONLY;").executeUpdate();

            GenreEntity genreEntity= genreEntityManager.find(GenreEntity.class, id);

            genreEntityManager.getTransaction().commit();
        return genreEntity;
    }

    @Override
    public List<GenreEntity> readAll() {
        EntityManager genreEntityManager = connectionManager.open();

        genreEntityManager.getTransaction().begin();
        List<GenreEntity> resultList = genreEntityManager.createQuery("FROM GenreEntity", GenreEntity.class).getResultList();
        genreEntityManager.getTransaction().commit();
        genreEntityManager.close();
        return resultList;
    }

    @Override
    public void delete(Long id) {
        EntityManager genreEntityManager = connectionManager.open();

        genreEntityManager.getTransaction().begin();
        GenreEntity genreToRemove = genreEntityManager.find(GenreEntity.class, id);
        genreEntityManager.remove(genreToRemove);
        genreEntityManager.getTransaction().commit();
        genreEntityManager.close();
    }

    @Override
    public void update(GenreEntity genreEntity) {
        EntityManager genreEntityManager = connectionManager.open();

        genreEntityManager.getTransaction().begin();
        genreEntityManager.merge(genreEntity);
        genreEntityManager.getTransaction().commit();
        genreEntityManager.close();
    }
}

