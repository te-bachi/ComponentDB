package net.bachi.componentdb.integration.build;

import net.bachi.componentdb.business.model.Manufacturer;
import net.bachi.componentdb.integration.DAOFactory;
import net.bachi.componentdb.integration.ManufacturerDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CreateManufacturer implements Creatable {

    private ManufacturerDAO manufacturerDAO;

    public CreateManufacturer() {
        manufacturerDAO = DAOFactory.getInstance().getManufacturerDAO();
    }

    public void tryCreate() {
        if (isEmpty() == false) {
            System.out.println("Data found! Can't reload data...");
        } else {
            System.out.println("Create manufacturers...");
            create();
        }
    }

    public boolean isEmpty() {
        List<Manufacturer> manufacturers = manufacturerDAO.findAll();
        if (manufacturers.size() > 0) {
            return false;
        }
        return true;
    }

    public void create() {
        Manufacturer m0 = new Manufacturer("Unbekannt");
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

        manufacturerDAO.save(m0);
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

    public static void main(String[] args) {
        new CreateManufacturer().tryCreate();
    }
}
