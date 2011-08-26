package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.AttributeGroup;
import net.bachi.componentdb.integration.AttributeGroupDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttributeGroupDAOHibernate extends GenericDAOHibernate<AttributeGroup, Integer> implements AttributeGroupDAO {
    @SuppressWarnings("unchecked")
    public List<AttributeGroup> findAll() {
        return HibernateUtil.getManager().createQuery("select a from AttributeGroup a").getResultList();
    }

    public AttributeGroup findByName(String name) {
        return (AttributeGroup) HibernateUtil.getManager().createQuery("select a from AttributeGroup a WHERE a.name = :name").setParameter("name", name).getSingleResult();
    }
}
