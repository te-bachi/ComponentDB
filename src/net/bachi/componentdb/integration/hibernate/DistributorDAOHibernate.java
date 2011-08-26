package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Distributor;
import net.bachi.componentdb.integration.DistributorDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class DistributorDAOHibernate extends GenericDAOHibernate<Distributor, Integer> implements DistributorDAO {
    @SuppressWarnings("unchecked")
    public List<Distributor> findAll() {
        return HibernateUtil.getManager().createQuery("select d from Distributor d").getResultList();
    }

    public Distributor findByName(String name) {
        return (Distributor) HibernateUtil.getManager().createQuery("select d from Distributor d WHERE d.name = :name").setParameter("name", name).getSingleResult();
    }
}
