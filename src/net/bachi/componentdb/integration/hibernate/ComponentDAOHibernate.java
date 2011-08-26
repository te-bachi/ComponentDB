package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.integration.ComponentDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class ComponentDAOHibernate extends GenericDAOHibernate<Component, Integer> implements ComponentDAO {
    @SuppressWarnings("unchecked")
    public List<Component> findAll() {
        return HibernateUtil.getManager().createQuery("select c from Component c").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Component> findExact(String searchString) {
        return HibernateUtil.getManager().createQuery("select c from Component c").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Component> findWildcard(String searchString) {
        return HibernateUtil.getManager().createQuery("select c from Component c").getResultList();
    }
}
