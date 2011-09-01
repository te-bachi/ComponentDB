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

            Category c0  = new Category("Elektronik");
            categoryDAO.save(c0);

            Category c11  = new Category(c0, "Aktive Bauelemente");
            Category c12  = new Category(c0, "Passive Bauelemente");
            Category c13  = new Category(c0, "Elektromechanische Bauelemente");
            Category c14  = new Category(c0, "Elektrotechnik");

            categoryDAO.save(c11);
            categoryDAO.save(c12);
            categoryDAO.save(c13);
            categoryDAO.save(c14);

            // Elektromechanische Bauelemente
            Category c41  = new Category(c13, "Leiterplatten");
            Category c42  = new Category(c13, "Relais");
            Category c43  = new Category(c13, "Schalter");
            Category c44  = new Category(c13, "Taster");
            Category c45  = new Category(c13, "Steckverbinder");
            Category c46  = new Category(c13, "Montagematerial");

            categoryDAO.save(c41);
            categoryDAO.save(c42);
            categoryDAO.save(c43);
            categoryDAO.save(c44);
            categoryDAO.save(c45);
            categoryDAO.save(c46);

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

            /******************************************************************
             * Passive Bauelemente
             *****************************************************************/

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

            /******************************************************************
             * Aktive Bauelemente
             *****************************************************************/
            
            // Aktive Bauelementec
            Category c21  = new Category(c11, "Analoge Schaltungen");
            Category c22  = new Category(c11, "Digitale Schaltungen");
            Category c23  = new Category(c11, "Diskrete Halbleiter");
            Category c24  = new Category(c11, "Optoelektronik");

            categoryDAO.save(c21);
            categoryDAO.save(c22);
            categoryDAO.save(c23);
            categoryDAO.save(c24);

            // Aktive Bauelemente -> Analoge Schaltungen
            Category c81 = new Category(c21, "Operationsverstärker");
            Category c82 = new Category(c21, "Schnittstellen-ICs");
            Category c83 = new Category(c21, "Spannungsreferenzen");
            Category c84 = new Category(c21, "Spannungsregler");
            Category c85 = new Category(c21, "Treiber-ICs");

            categoryDAO.save(c81);
            categoryDAO.save(c82);
            categoryDAO.save(c83);
            categoryDAO.save(c84);
            categoryDAO.save(c85);

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

            // Aktive Bauelemente -> Diskrete Halbleiter
            Category c91 = new Category(c23, "Brückengleichrichter");
            Category c92 = new Category(c23, "Dioden");
            Category c93 = new Category(c23, "Transistoren");
            Category c94 = new Category(c23, "FETs");
            Category c95 = new Category(c23, "MOSFETs");
            Category c96 = new Category(c23, "IGBTs");

            categoryDAO.save(c91);
            categoryDAO.save(c92);
            categoryDAO.save(c93);
            categoryDAO.save(c94);
            categoryDAO.save(c95);
            categoryDAO.save(c96);

            // Aktive Bauelemente -> Diskrete Halbleiter -> Dioden
            Category c101 = new Category(c92, "Gleichrichterdioden");
            Category c102 = new Category(c92, "Schottky-Dioden");
            Category c103 = new Category(c92, "Schutzdioden");
            Category c104 = new Category(c92, "Zenerdioden");

            categoryDAO.save(c101);
            categoryDAO.save(c102);
            categoryDAO.save(c103);
            categoryDAO.save(c104);

            // Aktive Bauelemente -> Diskrete Halbleiter -> Transistoren
            Category c111 = new Category(c93, "Kleinleistungstransistoren");
            Category c112 = new Category(c93, "Leistungstransistoren");
            Category c113 = new Category(c93, "Darlington-Transistoren");

            categoryDAO.save(c111);
            categoryDAO.save(c112);
            categoryDAO.save(c113);

            // Aktive Bauelemente -> Optoelektronik
            Category c121 = new Category(c24, "LEDs");
            Category c122 = new Category(c24, "LCD-Anzeigen");
            Category c123 = new Category(c24, "Optokoppler");
            Category c124 = new Category(c24, "Fotowiderstände");
            Category c125 = new Category(c24, "IR-Komponenten");
            Category c126 = new Category(c24, "Solarzellen");

            categoryDAO.save(c121);
            categoryDAO.save(c122);
            categoryDAO.save(c123);
            categoryDAO.save(c124);
            categoryDAO.save(c125);
            categoryDAO.save(c126);

            // Aktive Bauelemente -> Optoelektronik -> LEDs
            Category c131 = new Category(c121, "LEDs normal");
            Category c132 = new Category(c121, "LEDs in Chromfassung");
            Category c133 = new Category(c121, "LEDs mit Vorwiderstand");
            Category c134 = new Category(c121, "LED-Balkenanzeigen");

            categoryDAO.save(c131);
            categoryDAO.save(c132);
            categoryDAO.save(c133);
            categoryDAO.save(c134);

            // Aktive Bauelemente -> Optoelektronik -> IR-Komponenten
            Category c141 = new Category(c121, "IR-Empfänger");
            Category c142 = new Category(c121, "IR-Fotodioden");
            Category c143 = new Category(c121, "IR-Fototransistoren");
            Category c144 = new Category(c121, "IR-LEDs");

            categoryDAO.save(c141);
            categoryDAO.save(c142);
            categoryDAO.save(c143);
            categoryDAO.save(c144);




        }
    }
}
