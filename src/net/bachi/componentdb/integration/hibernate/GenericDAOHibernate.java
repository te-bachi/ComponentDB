package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.integration.GenericDAO;

import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Copyright (C) 2011 ZHAW
 * @author Lukas Funk <fulu@zhaw.ch>
 */
public abstract class GenericDAOHibernate<T extends Serializable, ID  extends Number> implements GenericDAO<T, ID> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericDAOHibernate() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public final Class<T> getPersistentClass() {
        return this.persistentClass;
    }

    public void save(T entity) throws PersistenceException {
        
        EntityTransaction transaction = HibernateUtil.getTransaction();
        try {
            transaction.begin();
            HibernateUtil.getManager().persist(entity);
            transaction.commit();
        } catch (Exception e ) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenceException("Could not saveSession from db.", e);
        }
    }

    public void update(T entity) throws PersistenceException {
        EntityTransaction transaction = HibernateUtil.getTransaction();
        try {
             transaction.begin();
             transaction.commit();
        } catch (Exception e ) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenceException("Could not update from db.", e);
        }
        
    }

    public void delete(T entity) throws PersistenceException {
        EntityTransaction transaction = HibernateUtil.getTransaction();
        try {
            transaction.begin();
            HibernateUtil.getManager().remove(entity);
            transaction.commit();
        } catch (Exception e ) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new PersistenceException("Could not removeSession from db.", e);
        }
    }

    public T findById(ID id) {
        return HibernateUtil.getManager().find(persistentClass, id);
    }

    
}
