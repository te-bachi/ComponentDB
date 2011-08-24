package net.bachi.componentdb.integration;

import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

/**
 * Copyright (C) 2011 ZHAW
 * @author Lukas Funk <fulu@zhaw.ch>
 */
public interface GenericDAO<T extends Serializable, ID extends Number> {
    void save(T entity) throws PersistenceException;
    void update(T entity) throws PersistenceException;
    void delete(T entity) throws PersistenceException;
    List<T> findAll();
    T findById(ID id);

}
