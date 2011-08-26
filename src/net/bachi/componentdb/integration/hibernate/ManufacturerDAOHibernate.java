package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Manufacturer;
import net.bachi.componentdb.integration.ManufacturerDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class ManufacturerDAOHibernate extends GenericDAOHibernate<Manufacturer, Integer> implements ManufacturerDAO {
    @SuppressWarnings("unchecked")
    public List<Manufacturer> findAll() {
        return HibernateUtil.getManager().createQuery("select m from Manufacturer m").getResultList();
    }

    public Manufacturer findByName(String name) {
        return (Manufacturer) HibernateUtil.getManager().createQuery("select m from Manufacturer m WHERE m.name = :name").setParameter("name", name).getSingleResult();
    }
}
