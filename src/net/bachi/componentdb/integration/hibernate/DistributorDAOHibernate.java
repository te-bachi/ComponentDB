package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Distributor;
import net.bachi.componentdb.integration.DistributorDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class DistributorDAOHibernate extends GenericDAOHibernate<Distributor, Integer> implements DistributorDAO {
    public List<Distributor> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
