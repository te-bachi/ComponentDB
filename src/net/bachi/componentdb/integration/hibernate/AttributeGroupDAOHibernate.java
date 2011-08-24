package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.AttributeGroup;
import net.bachi.componentdb.integration.AttributeGroupDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttributeGroupDAOHibernate extends GenericDAOHibernate<AttributeGroup, Integer> implements AttributeGroupDAO {
    public List<AttributeGroup> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
