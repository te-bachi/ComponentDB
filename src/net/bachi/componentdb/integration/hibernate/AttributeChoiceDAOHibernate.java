package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.AttributeChoice;
import net.bachi.componentdb.integration.AttributeChoiceDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttributeChoiceDAOHibernate extends GenericDAOHibernate<AttributeChoice, Integer> implements AttributeChoiceDAO {
    public List<AttributeChoice> findAll() {
        return null;
    }
}
