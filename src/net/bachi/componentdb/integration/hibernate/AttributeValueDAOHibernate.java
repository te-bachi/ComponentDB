package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.integration.AttributeValueDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttributeValueDAOHibernate extends GenericDAOHibernate<AttributeValue, Integer> implements AttributeValueDAO {
    public List<AttributeValue> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
