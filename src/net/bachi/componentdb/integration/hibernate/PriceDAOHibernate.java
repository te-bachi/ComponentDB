package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Price;
import net.bachi.componentdb.integration.PriceDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class PriceDAOHibernate extends GenericDAOHibernate<Price, Integer> implements PriceDAO {
    @SuppressWarnings("unchecked")
    public List<Price> findAll() {
        return HibernateUtil.getManager().createQuery("select p from Price p").getResultList();
    }
}
