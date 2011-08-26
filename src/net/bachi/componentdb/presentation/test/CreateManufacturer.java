package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Manufacturer;
import net.bachi.componentdb.integration.DAOFactory;
import net.bachi.componentdb.integration.ManufacturerDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CreateManufacturer {
    public static void main(String[] args) {
        ManufacturerDAO manufacturerDAO = DAOFactory.getInstance().getManufacturerDAO();

        List<Manufacturer> manufacturers = manufacturerDAO.findAll();
        if (manufacturers.size() > 0) {
            System.out.println("Data found! Can't reload data...");
        } else {
            Manufacturer m1 = new Manufacturer("Fairchild Semiconductor");
            Manufacturer m2 = new Manufacturer("NTE Electronics");
            Manufacturer m3 = new Manufacturer("NXP");
            Manufacturer m4 = new Manufacturer("ST Microelectronics");
            Manufacturer m5 = new Manufacturer("Texas Instruments");

            Manufacturer m6 = new Manufacturer("Epcos");
            Manufacturer m7 = new Manufacturer("Multicomp");
            Manufacturer m8 = new Manufacturer("Nichicon");
            Manufacturer m9 = new Manufacturer("Panasonic");
            Manufacturer m10 = new Manufacturer("Rubycon");
            Manufacturer m11 = new Manufacturer("Vishay");

            manufacturerDAO.save(m1);
            manufacturerDAO.save(m2);
            manufacturerDAO.save(m3);
            manufacturerDAO.save(m4);
            manufacturerDAO.save(m5);
            manufacturerDAO.save(m6);
            manufacturerDAO.save(m7);
            manufacturerDAO.save(m8);
            manufacturerDAO.save(m9);
            manufacturerDAO.save(m10);
            manufacturerDAO.save(m11);
        }
    }
}
