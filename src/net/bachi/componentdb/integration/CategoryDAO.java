package net.bachi.componentdb.integration;

import net.bachi.componentdb.business.model.Category;

/**
 * @author Andreas Bachmann
 */
public interface CategoryDAO extends GenericDAO<Category, Integer> {
    public Category findByName(String name);
}
