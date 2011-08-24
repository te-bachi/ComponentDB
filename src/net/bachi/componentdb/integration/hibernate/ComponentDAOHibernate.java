package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.integration.ComponentDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class ComponentDAOHibernate extends GenericDAOHibernate<Component, Integer> implements ComponentDAO {
    public List<Component> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
