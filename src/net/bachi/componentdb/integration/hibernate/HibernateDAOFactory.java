package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.integration.AttachmentDAO;
import net.bachi.componentdb.integration.AttributeValueDAO;
import net.bachi.componentdb.integration.AttributeDAO;
import net.bachi.componentdb.integration.AttributeGroupDAO;
import net.bachi.componentdb.integration.CategoryDAO;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.CountryDAO;
import net.bachi.componentdb.integration.CurrencyDAO;
import net.bachi.componentdb.integration.DAOFactory;
import net.bachi.componentdb.integration.DistributorDAO;
import net.bachi.componentdb.integration.ManufacturerDAO;
import net.bachi.componentdb.integration.PriceDAO;

/**
 * @author Andreas Bachmann
 */
public class HibernateDAOFactory extends DAOFactory {

    private GenericDAOHibernate instantiateDAO(final Class klass) {
        try {
            return (GenericDAOHibernate) klass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Can not instantiate DAO: " + klass, e);
        }
    }

    @Override
    public AttachmentDAO getAttachmentDAO() {
        return (AttachmentDAO) instantiateDAO(AttachmentDAOHibernate.class);
    }

    @Override
    public AttributeDAO getAttributeDAO() {
        return (AttributeDAO) instantiateDAO(AttributeDAOHibernate.class);
    }

    @Override
    public AttributeGroupDAO getAttributeGroupDAO() {
        return (AttributeGroupDAO) instantiateDAO(AttributeGroupDAOHibernate.class);
    }

    @Override
    public AttributeValueDAO getAttributeValueDAO() {
        return (AttributeValueDAO) instantiateDAO(AttributeValueDAOHibernate.class);
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return (CategoryDAO) instantiateDAO(CategoryDAOHibernate.class);
    }

    @Override
    public ManufacturerDAO getManufacturerDAO() {
        return (ManufacturerDAO) instantiateDAO(ManufacturerDAOHibernate.class);
    }

    @Override
    public ComponentDAO getComponentDAO() {
        return (ComponentDAO) instantiateDAO(ComponentDAOHibernate.class);
    }

    @Override
    public CountryDAO getCountryDAO() {
        return (CountryDAO) instantiateDAO(CountryDAOHibernate.class);
    }

    @Override
    public CurrencyDAO getCurrencyDAO() {
        return (CurrencyDAO) instantiateDAO(CurrencyDAOHibernate.class);
    }

    @Override
    public DistributorDAO getDistributorDAO() {
        return (DistributorDAO) instantiateDAO(DistributorDAOHibernate.class);
    }

    @Override
    public PriceDAO getPriceDAO() {
        return (PriceDAO) instantiateDAO(PriceDAOHibernate.class);
    }
}
