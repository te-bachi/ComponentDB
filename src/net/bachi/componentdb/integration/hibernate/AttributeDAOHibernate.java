package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.integration.AttributeDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttributeDAOHibernate extends GenericDAOHibernate<Attribute, Integer> implements AttributeDAO {
    public List<Attribute> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
