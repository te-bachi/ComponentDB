package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.AttributeChoice;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.integration.AttributeChoiceDAO;
import net.bachi.componentdb.integration.AttributeDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CreateAttribute {

    private AttributeDAO attributeDAO;
    private AttributeChoiceDAO attributeChoiceDAO;

    /**
     * Farnell
     * ICs -> Logik -> Gates & Inverter
     */
    public CreateAttribute() {
        attributeDAO = DAOFactory.getInstance().getAttributeDAO();
        attributeChoiceDAO = DAOFactory.getInstance().getAttributeChoiceDAO();

        List<Attribute> attribute = attributeDAO.findAll();
        if (attribute.size() > 0) {
            System.out.println("Data found! Can't reload data...");
        } else {
            createHersteller();
            createGehäuse();
            createTechnologie();
            createLogiktyp();
            createAnzahlEingänge();
            createKapazität();
        }

    }

    private void createHersteller() {
        Attribute attribute = new Attribute("Hersteller");
        attributeDAO.save(attribute);

        attributeChoiceDAO.save(new AttributeChoice(attribute, "Fairchild Semiconductor"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "NTE Electronics"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "NXP"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "ST Microelectronics"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "Texas Instruments"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "ON Semiconductor"));
    }

    private void createGehäuse() {
        Attribute attribute = new Attribute("Gehäuse");
        attributeDAO.save(attribute);

        attributeChoiceDAO.save(new AttributeChoice(attribute, "BGA"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "DIP"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "DQFN"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "DSBGA"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "PLCC"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "QFN"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "SOIC"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "SOP"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "SOT"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "SSOP"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "TSOP"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "TSSOP"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "LQFP"));
    }

    private void createTechnologie() {
        Attribute attribute = new Attribute("Technologie");
        attributeDAO.save(attribute);

        attributeChoiceDAO.save(new AttributeChoice(attribute, "HC"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "HCT"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "HCU"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "LS"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "TTL"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "CMOS"));
    }

    private void createLogiktyp() {
        Attribute attribute = new Attribute("Logiktyp");
        attributeDAO.save(attribute);

        attributeChoiceDAO.save(new AttributeChoice(attribute, "AND"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "NAND"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "OR"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "NOR"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "XOR"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "Latch"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "Multiplexer"));

    }

    private void createAnzahlEingänge() {
        Attribute attribute = new Attribute("Anzahl Eingänge");
        attributeDAO.save(attribute);

        // Anzahl Eingänge
        attributeChoiceDAO.save(new AttributeChoice(attribute, "1"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "2"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "3"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "4"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "5"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "6"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "7"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "8"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "9"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "10"));
    }

    private void createAnzahlPins() {
        Attribute attribute = new Attribute("Anzahl Pins");
        attributeDAO.save(attribute);

        attributeChoiceDAO.save(new AttributeChoice(attribute, "6"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "8"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "10"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "12"));
        attributeChoiceDAO.save(new AttributeChoice(attribute, "14"));
    }

    private void createKapazität() {

        
        Attribute a21 = new Attribute("Kapazität");
        Attribute a22 = new Attribute("Nennspannung");
        Attribute a23 = new Attribute("Montage");
        Attribute a24 = new Attribute("Rastermass");
    }

    public static void main(String[] args) {

   }
}
