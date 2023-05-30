package by.it_academy.vote_spring.dao.api;

import javax.persistence.EntityManager;

public interface IConnection extends AutoCloseable{
    EntityManager open();
}
