package net.bachi.componentdb.integration.build;

import net.bachi.componentdb.business.model.Country;
import net.bachi.componentdb.business.model.Currency;
import net.bachi.componentdb.business.model.Distributor;
import net.bachi.componentdb.integration.CountryDAO;
import net.bachi.componentdb.integration.CurrencyDAO;
import net.bachi.componentdb.integration.DAOFactory;
import net.bachi.componentdb.integration.DistributorDAO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CreateDistributor implements Creatable {
    private CurrencyDAO    currencyDAO;
    private CountryDAO     countryDAO;
    private DistributorDAO distributorDAO;

    public CreateDistributor() {
        currencyDAO    = DAOFactory.getInstance().getCurrencyDAO();
        countryDAO     = DAOFactory.getInstance().getCountryDAO();
        distributorDAO = DAOFactory.getInstance().getDistributorDAO();
    }

    public void tryCreate() {
        if (isEmpty() == false) {
            System.out.println("Data found! Can't reload data...");
        } else {
            System.out.println("Create distributors...");
            create();
        }
    }

    public boolean isEmpty() {
        List<Distributor> distributors = distributorDAO.findAll();
        if (distributors.size() > 0) {
            return false;
        }
        return true;
    }

    public void create() {
            Currency chf = new Currency("CHF", new BigDecimal("1.00"));
            Currency eur = new Currency("EUR", new BigDecimal("1.13"));

            currencyDAO.save(chf);
            currencyDAO.save(eur);

            Country ch = new Country(chf, "Schweiz", new byte[32], new BigDecimal("9.6"));
            Country de = new Country(eur, "Deutschland", new byte[32], new BigDecimal("19.0"));

            countryDAO.save(ch);
            countryDAO.save(de);

            Distributor distrelec = new Distributor(ch, "Distrelec", new byte[32], true);
            Distributor farnellCh = new Distributor(ch, "Farnell CH", new byte[32], false);
            Distributor farnellD = new Distributor(de, "Farnell D", new byte[32], false);
            Distributor reichelt = new Distributor(de, "Reichelt", new byte[32], true);
            Distributor conradCh = new Distributor(ch, "Conrad CH", new byte[32], true);
            Distributor conradD = new Distributor(de, "Conrad D", new byte[32], true);
            Distributor unknown = new Distributor(ch, "Unbekannt", new byte[32], true);

            distributorDAO.save(distrelec);
            distributorDAO.save(farnellCh);
            distributorDAO.save(farnellD);
            distributorDAO.save(reichelt);
            distributorDAO.save(conradCh);
            distributorDAO.save(conradD);
            distributorDAO.save(unknown);
    }

    public static void main(String[] args) {
        new CreateDistributor().tryCreate();
    }
}
