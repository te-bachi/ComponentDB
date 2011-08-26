package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.integration.CategoryDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CreateCategory {
    public static void main(String[] args) {
        CategoryDAO categoryDAO = DAOFactory.getInstance().getCategoryDAO();

        List<Category> categories = categoryDAO.findAll();
        if (categories.size() > 0) {
            System.out.println("Data found! Can't reload data...");
        } else {
            Category c11  = new Category("Aktive Bauelemente");
            Category c12  = new Category("Passive Bauelemente");
            Category c13  = new Category("Elektromechanische Bauelemente");
            Category c14  = new Category("Elektrotechnik");

            categoryDAO.save(c11);
            categoryDAO.save(c12);
            categoryDAO.save(c13);
            categoryDAO.save(c14);

            // Aktive Bauelemente
            Category c21  = new Category(c11, "Analoge Schaltungen");
            Category c22  = new Category(c11, "Digitale Schaltungen");
            Category c23  = new Category(c11, "Entwicklungswerkzeuge");
            Category c24  = new Category(c11, "Diskrete Halbleiter");
            Category c25  = new Category(c11, "Montagematerial für Halbleiter");
            Category c26  = new Category(c11, "Optoelektronik");

            categoryDAO.save(c21);
            categoryDAO.save(c22);
            categoryDAO.save(c23);
            categoryDAO.save(c24);
            categoryDAO.save(c25);
            categoryDAO.save(c26);

            // Passive Bauelemente
            Category c31  = new Category(c12, "Ferrite");
            Category c32  = new Category(c12, "Induktivitäten");
            Category c33  = new Category(c12, "Filter");
            Category c34  = new Category(c12, "Kleinsicherungen");
            Category c35  = new Category(c12, "Kondensatoren");
            Category c36  = new Category(c12, "Widerstände");
            Category c37  = new Category(c12, "Potentiometer");

            categoryDAO.save(c31);
            categoryDAO.save(c32);
            categoryDAO.save(c33);
            categoryDAO.save(c34);
            categoryDAO.save(c35);
            categoryDAO.save(c36);
            categoryDAO.save(c37);

            // Elektromechanische Bauelemente
            Category c41  = new Category(c13, "Leiterplatten");
            Category c42  = new Category(c13, "Relais");
            Category c43  = new Category(c13, "Schalter");
            Category c44  = new Category(c13, "Taster");
            Category c45  = new Category(c13, "Steckverbinder");

            categoryDAO.save(c41);
            categoryDAO.save(c42);
            categoryDAO.save(c43);
            categoryDAO.save(c44);
            categoryDAO.save(c45);

            // Elektrotechnik
            Category c51  = new Category(c14, "Gehäuse");
            Category c52  = new Category(c14, "Lüfter");
            Category c53  = new Category(c14, "Heizgeräte");
            Category c54  = new Category(c14, "Installationsmaterial");
            Category c55  = new Category(c14, "Kabel");

            categoryDAO.save(c51);
            categoryDAO.save(c52);
            categoryDAO.save(c53);
            categoryDAO.save(c54);
            categoryDAO.save(c55);

            // Passive Bauelemente -> Kondensatoren
            Category c61  = new Category(c35, "Aluminium-Becher Elektrolytkondensatoren");
            Category c62  = new Category(c35, "Tantal Elektrolytkondensatoren");
            Category c63  = new Category(c35, "Folienkondensatoren");
            Category c64  = new Category(c35, "Keramik-Scheibenkondensatoren");
            Category c65  = new Category(c35, "Keramik-Vielschichtkondensatoren");

            categoryDAO.save(c61);
            categoryDAO.save(c62);
            categoryDAO.save(c63);
            categoryDAO.save(c64);
            categoryDAO.save(c65);

            // Aktive Bauelemente -> Digitale Schaltungen
            Category c71  = new Category(c22, "4000er Logik");
            Category c72  = new Category(c22, "74er Logik");
            Category c73  = new Category(c22, "Mikrocontroller");
            Category c74  = new Category(c22, "Oszillatoren");
            Category c75  = new Category(c22, "Quarze");
            Category c76  = new Category(c22, "Programmierbare Logik");

            categoryDAO.save(c71);
            categoryDAO.save(c72);
            categoryDAO.save(c73);
            categoryDAO.save(c74);
            categoryDAO.save(c75);
            categoryDAO.save(c76);

        }
    }
}
