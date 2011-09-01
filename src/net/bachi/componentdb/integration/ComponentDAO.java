package net.bachi.componentdb.integration;

import net.bachi.componentdb.business.model.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Andreas Bachmann
 */
public interface ComponentDAO extends GenericDAO<Component, Integer> {
    public List<Component> findExact(String searchString, Map<String, String> check);
    public List<Component> findWildcard(String searchString, Map<String, String> check);
}
