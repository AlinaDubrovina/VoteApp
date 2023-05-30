package by.it_academy.vote_spring.dao.util;

import by.it_academy.vote_spring.dao.api.IConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ConnectionManager implements IConnection {

    private final EntityManagerFactory factory;
    public static final String PERSISTENT_UNIT_NAME = "vote";

    public ConnectionManager(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public EntityManager open() {
        return factory.createEntityManager();
    }

    @Override
    public void close() {
        factory.close();
    }
}