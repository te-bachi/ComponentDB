package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.AttributeGroup;
import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.integration.AttributeGroupDAO;
import net.bachi.componentdb.integration.AttributeValueDAO;
import net.bachi.componentdb.integration.AttributeDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CreateAttribute {

    private AttributeDAO attributeDAO;
    private AttributeValueDAO attributeValueDAO;
    private AttributeGroupDAO attributeGroupDAO;

    /**
     * Farnell
     * ICs -> Logik -> Gates & Inverter
     */
    public CreateAttribute() {
        attributeDAO = DAOFactory.getInstance().getAttributeDAO();
        attributeValueDAO = DAOFactory.getInstance().getAttributeValueDAO();
        attributeGroupDAO = DAOFactory.getInstance().getAttributeGroupDAO();

        List<Attribute> attributes = attributeDAO.findAll();
        if (attributes.size() > 0) {
            System.out.println("Data found! Can't reload data...");
        } else {
            createLogikgatterAttributes();
            createLogikgatterGroup();

            createKondensatorAttributes();
            createKondensatorGroup();
        }

    }

    private Attribute logikgatterGehäuse;
    private Attribute logikgatterTechnologie;
    private Attribute logikgatterLogiktyp;
    private Attribute logikgatterAnzahlEingänge;
    private Attribute logikgatterAnzahlPins;
    private Attribute logikgatterVersorgungsspannung;

    private void createLogikgatterAttributes() {
        createLogikgatterGehäuse();
        createLogikgatterTechnologie();
        createLogikgatterLogiktyp();
        createLogikgatterAnzahlEingänge();
        createLogikgatterAnzahlPins();
        createLogikgatterVersorgungsspannung();
    }

    private void createLogikgatterGroup() {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(logikgatterGehäuse);
        attributes.add(logikgatterTechnologie);
        attributes.add(logikgatterLogiktyp);
        attributes.add(logikgatterAnzahlEingänge);
        attributes.add(logikgatterAnzahlPins);
        attributes.add(logikgatterVersorgungsspannung);

        AttributeGroup logikgatterGroup = new AttributeGroup("Logikgatter", attributes);
        attributeGroupDAO.save(logikgatterGroup);
    }

    private void createLogikgatterGehäuse() {
        logikgatterGehäuse = new Attribute("Gehäuse");
        attributeDAO.save(logikgatterGehäuse);

        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "BGA"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "DIP"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "DQFN"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "DSBGA"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "PLCC"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "QFN"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "SOIC"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "SOP"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "SOT"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "SSOP"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "TSOP"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "TSSOP"));
        attributeValueDAO.save(new AttributeValue(logikgatterGehäuse, "LQFP"));
    }

    private void createLogikgatterTechnologie() {
        logikgatterTechnologie = new Attribute("Technologie");
        attributeDAO.save(logikgatterTechnologie);

        attributeValueDAO.save(new AttributeValue(logikgatterTechnologie, "HC"));
        attributeValueDAO.save(new AttributeValue(logikgatterTechnologie, "HCT"));
        attributeValueDAO.save(new AttributeValue(logikgatterTechnologie, "HCU"));
        attributeValueDAO.save(new AttributeValue(logikgatterTechnologie, "LS"));
        attributeValueDAO.save(new AttributeValue(logikgatterTechnologie, "TTL"));
        attributeValueDAO.save(new AttributeValue(logikgatterTechnologie, "CMOS"));
    }

    private void createLogikgatterLogiktyp() {
        logikgatterLogiktyp = new Attribute("Logiktyp");
        attributeDAO.save(logikgatterLogiktyp);

        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "AND"));
        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "NAND"));
        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "OR"));
        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "NOR"));
        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "XOR"));
        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "Latch"));
        attributeValueDAO.save(new AttributeValue(logikgatterLogiktyp, "Multiplexer"));

    }

    private void createLogikgatterAnzahlEingänge() {
        logikgatterAnzahlEingänge = new Attribute("Anzahl Eingänge");
        attributeDAO.save(logikgatterAnzahlEingänge);

        // Anzahl Eingänge
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "1"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "2"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "3"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "4"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "5"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "6"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "7"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "8"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "9"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlEingänge, "10"));
    }

    private void createLogikgatterAnzahlPins() {
        logikgatterAnzahlPins = new Attribute("Anzahl Pins");
        attributeDAO.save(logikgatterAnzahlPins);

        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlPins, "6"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlPins, "8"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlPins, "10"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlPins, "12"));
        attributeValueDAO.save(new AttributeValue(logikgatterAnzahlPins, "14"));
    }

    private void createLogikgatterVersorgungsspannung() {
        logikgatterVersorgungsspannung = new Attribute("Versorgungsspannung");
        attributeDAO.save(logikgatterVersorgungsspannung);

        attributeValueDAO.save(new AttributeValue(logikgatterVersorgungsspannung, "1.65V bis 3.6V"));
        attributeValueDAO.save(new AttributeValue(logikgatterVersorgungsspannung, "1.65V bis 5.5V"));
        attributeValueDAO.save(new AttributeValue(logikgatterVersorgungsspannung, "2.7V bis 3.6V"));
        attributeValueDAO.save(new AttributeValue(logikgatterVersorgungsspannung, "2V bis 5.5V"));
        attributeValueDAO.save(new AttributeValue(logikgatterVersorgungsspannung, "2V bis 6V"));
        attributeValueDAO.save(new AttributeValue(logikgatterVersorgungsspannung, "4.5V bis 5.5V"));
    }

    private Attribute kondensatorKapazität;
    private Attribute kondensatorNennspannung;
    private Attribute kondensatorMontage;
    private Attribute kondensatorRastermass;
    private Attribute kondensatorHöhe;
    private Attribute kondensatorDurchmesser;

    private void createKondensatorAttributes() {
        createKondensatorKapazität();
        createKondensatorNennspannung();
        createKondensatorMontage();
        createKondensatorRastermass();
        createKondensatorHöhe();
        createKondensatorDurchmesser();
    }

    private void createKondensatorGroup() {
        List<Attribute> attributes = new ArrayList<Attribute>();
        attributes.add(kondensatorKapazität);
        attributes.add(kondensatorNennspannung);
        attributes.add(kondensatorMontage);
        attributes.add(kondensatorRastermass);
        attributes.add(kondensatorHöhe);
        attributes.add(kondensatorDurchmesser);

        AttributeGroup elkoGroup = new AttributeGroup("Elko", attributes);
        attributeGroupDAO.save(elkoGroup);
    }

    private void createKondensatorKapazität() {
        kondensatorKapazität = new Attribute("Kapazität");
        attributeDAO.save(kondensatorKapazität);

        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "0.47µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "2.2µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "4.7µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "6.8µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "10µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "22µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "33µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "47µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "100µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "150µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "220µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "330µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "470µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "680µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "1'000µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "1'500µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "2'200µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "3'300µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "4'700µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "5'600µF"));
        attributeValueDAO.save(new AttributeValue(kondensatorKapazität, "6'800µF"));
    }

    private void createKondensatorNennspannung() {
        kondensatorNennspannung = new Attribute("Nennspannung");
        attributeDAO.save(kondensatorNennspannung);

        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "6.3V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "10V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "16V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "25V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "35V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "50V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "63V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "100V"));
        attributeValueDAO.save(new AttributeValue(kondensatorNennspannung, "450V"));
    }

    private void createKondensatorMontage() {
        kondensatorMontage = new Attribute("Montage");
        attributeDAO.save(kondensatorMontage);

        attributeValueDAO.save(new AttributeValue(kondensatorMontage, "Through Hole"));
        attributeValueDAO.save(new AttributeValue(kondensatorMontage, "SMD"));

    }

    private void createKondensatorRastermass() {
        kondensatorRastermass = new Attribute("Rastermass");
        attributeDAO.save(kondensatorRastermass);

        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "1.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "2.0mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "2.2mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "2.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "3.1mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "3.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "4.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "5.0mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorRastermass, "7.5mm"));
    }

    private void createKondensatorHöhe() {
        kondensatorHöhe = new Attribute("Höhe");
        attributeDAO.save(kondensatorHöhe);

        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "7mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "7.7mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "10mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "11mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "11.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "12.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "16mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "20mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "23mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "25mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "26mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "30mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "31.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorHöhe, "35mm"));
    }

    private void createKondensatorDurchmesser() {
        kondensatorDurchmesser = new Attribute("Durchmesser");
        attributeDAO.save(kondensatorDurchmesser);

        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "4mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "6mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "6.3mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "8mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "10mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "12.5mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "13mm"));
        attributeValueDAO.save(new AttributeValue(kondensatorDurchmesser, "16mm"));
    }

    public static void main(String[] args) {
        new CreateAttribute();
   }
}
