package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.integration.ComponentDAO;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Andreas Bachmann
 */
public class ComponentDAOHibernate extends GenericDAOHibernate<Component, Integer> implements ComponentDAO {

    private static Logger log = Logger.getLogger(ComponentDAOHibernate.class);

    private static final String sqlPrefix = "SELECT DISTINCT c                   " +
                                            "  FROM Component c                  " +
                                            "  JOIN c.manufacturer m             " +
                                            "  LEFT JOIN c.attributeValues v     " +
                                            " WHERE 1 = 2                        ";

    @SuppressWarnings("unchecked")
    public List<Component> findAll() {
        return HibernateUtil.getManager().createQuery("select c from Component c").getResultList();
    }

    public List<Component> findExact(String searchString, Map<String, String> check) {
        return find(searchString, check, " = :searchString");
    }

    public List<Component> findWildcard(String searchString, Map<String, String> check) {
        return find("%" + searchString + "%", check, " LIKE :searchString");
    }

    @SuppressWarnings("unchecked")
    private List<Component> find(String searchString, Map<String, String> check, String sqlPart) {
        StringBuilder sqlQuery;
        boolean       pass;

        sqlQuery = new StringBuilder();
        pass     = false;

        sqlQuery.append(sqlPrefix);

        for (String key : check.keySet()) {
            String value = check.get(key);
            if (value.equals("true")) {
                pass = true;
                sqlQuery.append(" OR ");
                sqlQuery.append(ColumnTranslation.translate(key));
                sqlQuery.append(sqlPart);
            }
        }

        log.info(sqlQuery.toString());

        if (pass) {
            return HibernateUtil.getManager().createQuery(sqlQuery.toString()).setParameter("searchString", searchString).getResultList();
        }

        return null;
    }
}
