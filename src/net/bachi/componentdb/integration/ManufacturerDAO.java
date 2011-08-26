package net.bachi.componentdb.integration;

import net.bachi.componentdb.business.model.Manufacturer;

/**
 * @author Andreas Bachmann
 */
public interface ManufacturerDAO extends GenericDAO<Manufacturer, Integer> {
    public Manufacturer findByName(String name);
}
