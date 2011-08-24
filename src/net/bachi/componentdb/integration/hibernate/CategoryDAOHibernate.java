package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.integration.CategoryDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CategoryDAOHibernate extends GenericDAOHibernate<Category, Integer> implements CategoryDAO {
    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        return HibernateUtil.getManager().createQuery("select c from Category c").getResultList();
    }
}
