package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Country;
import net.bachi.componentdb.integration.CountryDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CountryDAOHibernate extends GenericDAOHibernate<Country, Integer> implements CountryDAO {
    @SuppressWarnings("unchecked")
    public List<Country> findAll() {
        return HibernateUtil.getManager().createQuery("select c from Country c").getResultList();
    }
}
