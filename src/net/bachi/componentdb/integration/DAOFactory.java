package net.bachi.componentdb.integration;

import net.bachi.componentdb.integration.hibernate.HibernateDAOFactory;

public abstract class DAOFactory {

    public static final Class<HibernateDAOFactory> HIBERNATE = HibernateDAOFactory.class;

    public static DAOFactory getInstance(final Class<? extends DAOFactory> factory) {
        try {
            return (DAOFactory) factory.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Could not create DAOFactory: " + factory, ex);
        }
    }


    public static DAOFactory getInstance() {
        try {
            return (DAOFactory) HIBERNATE.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException("Could not create DAOFactory: " + HIBERNATE, ex);
        }
    }

    public abstract AttachmentDAO getAttachmentDAO();
    public abstract AttributeDAO getAttributeDAO();
    public abstract AttributeGroupDAO getAttributeGroupDAO();
    public abstract AttributeValueDAO getAttributeValueDAO();
    public abstract AttributeChoiceDAO getAttributeChoiceDAO();
    public abstract CategoryDAO getCategoryDAO();
    public abstract ComponentDAO getComponentDAO();
    public abstract CountryDAO getCountryDAO();
    public abstract CurrencyDAO getCurrencyDAO();
    public abstract DistributorDAO getDistributorDAO();
    public abstract PartNumberDAO getPartNumberDAO();
    public abstract PriceDAO getPriceDAO();
}
