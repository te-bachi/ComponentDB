package net.bachi.componentdb.integration;

import net.bachi.componentdb.business.model.Component;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public interface ComponentDAO extends GenericDAO<Component, Integer> {
    public List<Component> findExact(String searchString);
    public List<Component> findWildcard(String searchString);
}
