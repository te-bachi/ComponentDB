package net.bachi.componentdb.integration;

import net.bachi.componentdb.business.model.AttributeGroup;

/**
 * @author Andreas Bachmann
 */
public interface AttributeGroupDAO extends GenericDAO<AttributeGroup, Integer> {
    public AttributeGroup findByName(String name);
}
