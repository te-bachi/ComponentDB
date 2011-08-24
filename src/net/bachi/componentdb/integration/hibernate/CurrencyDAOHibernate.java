package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Currency;
import net.bachi.componentdb.integration.CurrencyDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CurrencyDAOHibernate extends GenericDAOHibernate<Currency, Integer> implements CurrencyDAO {
    public List<Currency> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
