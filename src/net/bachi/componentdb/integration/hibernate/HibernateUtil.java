package net.bachi.componentdb.integration.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final String PERSISTENCE_UNIT_NAME = "componentdb";

    private static EntityManager manager;
    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        manager = emf.createEntityManager();
    }

    private HibernateUtil() {
        //
    }
    
    public static EntityManager getManager() {
        return manager;
    }
    
    public static EntityTransaction getTransaction() {
        return manager.getTransaction();
    }
}