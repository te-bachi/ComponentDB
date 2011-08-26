package net.bachi.componentdb.integration;

import net.bachi.componentdb.business.model.Distributor;

/**
 * @author Andreas Bachmann
 */
public interface DistributorDAO extends GenericDAO<Distributor, Integer> {
    public Distributor findByName(String name);
}
