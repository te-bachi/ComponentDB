package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.integration.AttributeValueDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttributeValueDAOHibernate extends GenericDAOHibernate<AttributeValue, Integer> implements AttributeValueDAO {
    @SuppressWarnings("unchecked")
    public List<AttributeValue> findAll() {
        return HibernateUtil.getManager().createQuery("select a from AttributeValue a").getResultList();
    }
}
