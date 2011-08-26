package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.PartNumber;
import net.bachi.componentdb.integration.PartNumberDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class PartNumberDAOHibernate extends GenericDAOHibernate<PartNumber, Integer> implements PartNumberDAO {
    @SuppressWarnings("unchecked")
    public List<PartNumber> findAll() {
        return HibernateUtil.getManager().createQuery("select p from PartNumber p").getResultList();
    }
}
