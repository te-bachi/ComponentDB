package net.bachi.componentdb.integration.build;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.AttributeGroup;
import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.Distributor;
import net.bachi.componentdb.business.model.Manufacturer;
import net.bachi.componentdb.business.model.Price;
import net.bachi.componentdb.integration.AttributeGroupDAO;
import net.bachi.componentdb.integration.CategoryDAO;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;
import net.bachi.componentdb.integration.DistributorDAO;
import net.bachi.componentdb.integration.ManufacturerDAO;
import net.bachi.componentdb.integration.PriceDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Andreas Bachmann
 */
public class CreateComponent implements Creatable {

    private CategoryDAO categoryDAO;
    private ManufacturerDAO manufacturerDAO;
    private ComponentDAO componentDAO;
    private DistributorDAO distributorDAO;
    private PriceDAO priceDAO;
    private AttributeGroupDAO attributeGroupDAO;

    public CreateComponent() {
        categoryDAO = DAOFactory.getInstance().getCategoryDAO();
        manufacturerDAO = DAOFactory.getInstance().getManufacturerDAO();
        componentDAO = DAOFactory.getInstance().getComponentDAO();
        distributorDAO = DAOFactory.getInstance().getDistributorDAO();
        priceDAO = DAOFactory.getInstance().getPriceDAO();
        attributeGroupDAO = DAOFactory.getInstance().getAttributeGroupDAO();
    }

    public void tryCreate() {
        if (isEmpty() == false) {
            System.out.println("Data found! Can't reload data...");
        } else {
            System.out.println("Create components...");
            create();
        }
    }

    public boolean isEmpty() {
        List<Component> components = componentDAO.findAll();
        if (components.size() > 0) {
            return false;
        }
        return true;
    }

    public void create() {
        create74HC244();
        create74HC74();
        create74HC74_2();
        createTestComponents();
    }

    private void create74HC244() {
        Category category = categoryDAO.findByName("74er Logik");
        Manufacturer manufacturer = manufacturerDAO.findByName("Fairchild Semiconductor");
        Distributor distributor = distributorDAO.findByName("Distrelec");

        Component component = new Component(category, manufacturer, distributor, "642663", "74HC244", "Logic-IC Octal 3-State Driver DIL-20", null, (short) 0);
        createLogikgatterValues(component);
        componentDAO.save(component);

        Price p1 = new Price(component, (short) 1, new BigDecimal("1.19"));
        Price p2 = new Price(component, (short) 25, new BigDecimal("0.97"));
        Price p3 = new Price(component, (short) 100, new BigDecimal("0.81"));

        priceDAO.save(p1);
        priceDAO.save(p2);
        priceDAO.save(p3);
    }

    private void create74HC74() {
        Category category = categoryDAO.findByName("74er Logik");
        Manufacturer manufacturer = manufacturerDAO.findByName("Fairchild Semiconductor");
        Distributor distributor1 = distributorDAO.findByName("Distrelec");

        Component component1 = new Component(category, manufacturer, distributor1, "643212", "74HC74", "Logic-IC Dual D-Type FF DIL-14 ", null, (short) 5);
        createLogikgatterValues(component1);
        componentDAO.save(component1);

        Price p1 = new Price(component1, (short) 1, new BigDecimal("0.65"));
        Price p2 = new Price(component1, (short) 25, new BigDecimal("0.54"));
        Price p3 = new Price(component1, (short) 100, new BigDecimal("0.43"));

        priceDAO.save(p1);
        priceDAO.save(p2);
        priceDAO.save(p3);

        Distributor distributor2 = distributorDAO.findByName("Reichelt");

        Component component2 = new Component(category, manufacturer, distributor2, "74HC 74", "74HC74", "Logic-IC Dual D-Type FF DIL-14 ", null, (short) 5);
        createLogikgatterValues(component2);
        componentDAO.save(component2);

        Price p4 = new Price(component2, (short) 1, new BigDecimal("0.18"));

        priceDAO.save(p4);
    }

    private void create74HC74_2() {
        Category category = categoryDAO.findByName("74er Logik");
        Manufacturer manufacturer = manufacturerDAO.findByName("NXP");
        Distributor distributor1 = distributorDAO.findByName("Distrelec");

        Component component = new Component(category, manufacturer, distributor1, "649484", "74HC74", "Logic-IC Dual D-Type FF SO-14", null, (short) 10);
        createLogikgatterValues(component);
        componentDAO.save(component);

        Price p1 = new Price(component, (short) 1, new BigDecimal("0.59"));
        Price p2 = new Price(component, (short) 25, new BigDecimal("0.54"));
        Price p3 = new Price(component, (short) 100, new BigDecimal("0.43"));

        priceDAO.save(p1);
        priceDAO.save(p2);
        priceDAO.save(p3);
    }

    private void createLogikgatterValues(Component component) {
        Random rand = new Random();
        AttributeGroup attributeGroup = attributeGroupDAO.findByName("Logikgatter");
        List<Attribute> attributes = attributeGroup.getAttributes();
        List<AttributeValue> attributeValues;
        AttributeValue attributeValue;
        List<AttributeValue> randValues = new ArrayList<AttributeValue>();
        int i;

        System.out.println("=== " + component.getName() + " ===");
        for (Attribute attribute : attributes) {
            attributeValues = attribute.getAttributeValues();
            i = rand.nextInt(attributeValues.size());
            attributeValue = attributeValues.get(i);

            System.out.println(attribute.getName() + ": " + attributeValue.getValue() + " (" + i + ")");
            randValues.add(attributeValue);
        }
        System.out.println();

        component.setAttributeValues(randValues);
    }

    private void createTestComponents() {
        Category kondensator1 = categoryDAO.findByName("Aluminium-Becher Elektrolytkondensatoren");
        Category kondensator2 = categoryDAO.findByName("Tantal Elektrolytkondensatoren");
        Category kondensator3 = categoryDAO.findByName("Folienkondensatoren");
        Category kondensator4 = categoryDAO.findByName("Keramik-Scheibenkondensatoren");
        Category spannungsreg = categoryDAO.findByName("Spannungsregler");
        Category uC           = categoryDAO.findByName("Mikrocontroller");
        Category logik74      = categoryDAO.findByName("74er Logik");
        Category quarz        = categoryDAO.findByName("Quarze");
        Category transistoren = categoryDAO.findByName("Kleinleistungstransistoren");
        Category irSender     = categoryDAO.findByName("IR-Fotodioden");
        Category irReceiver   = categoryDAO.findByName("IR-Empfänger");

        Manufacturer manufacturer = manufacturerDAO.findByName("Unbekannt");
        Distributor distributor = distributorDAO.findByName("Unbekannt");

        List<Component> components = new ArrayList<Component>();

        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST 1", "TEST 1", null, (short) 0));
        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST 2", "TEST 2", null, (short) 0));
        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST 3", "TEST 3", null, (short) 0));
        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST 4", "TEST 4", null, (short) 0));
        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST 5", "TEST 5", null, (short) 0));

        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST KOND", "TEST 6", null, (short) 0));
        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST KOND", "TEST 7", null, (short) 0));
        components.add(new Component(kondensator1, manufacturer, distributor, null, "TEST KOND", "TEST 8", null, (short) 0));
        components.add(new Component(kondensator2, manufacturer, distributor, null, "TEST KOND", "TEST 9", null, (short) 0));
        components.add(new Component(kondensator3, manufacturer, distributor, null, "TEST KOND", "TEST 10", null, (short) 0));
        components.add(new Component(kondensator4, manufacturer, distributor, null, "TEST KOND", "TEST 11", null, (short) 0));

        components.add(new Component(uC, manufacturer, distributor, null, "TEST SEMICOND", "TEST 12", null, (short) 0));
        components.add(new Component(uC, manufacturer, distributor, null, "TEST SEMICOND", "TEST 13", null, (short) 0));
        components.add(new Component(uC, manufacturer, distributor, null, "TEST SEMICOND", "TEST 14", null, (short) 0));

        components.add(new Component(logik74, manufacturer, distributor, null, "TEST SEMICOND", "TEST 15", null, (short) 0));
        components.add(new Component(logik74, manufacturer, distributor, null, "TEST SEMICOND", "TEST 16", null, (short) 0));
        components.add(new Component(logik74, manufacturer, distributor, null, "TEST SEMICOND", "TEST 17", null, (short) 0));
        components.add(new Component(logik74, manufacturer, distributor, null, "TEST SEMICOND", "TEST 18", null, (short) 0));

        components.add(new Component(spannungsreg, manufacturer, distributor, null, "TEST SEMICOND", "TEST 19", null, (short) 0));
        components.add(new Component(spannungsreg, manufacturer, distributor, null, "TEST SEMICOND", "TEST 20", null, (short) 0));

        components.add(new Component(quarz, manufacturer, distributor, null, "TEST SEMICOND", "TEST 21", null, (short) 0));
        components.add(new Component(quarz, manufacturer, distributor, null, "TEST SEMICOND", "TEST 22", null, (short) 0));
        components.add(new Component(quarz, manufacturer, distributor, null, "TEST SEMICOND", "TEST 23", null, (short) 0));
        components.add(new Component(quarz, manufacturer, distributor, null, "TEST SEMICOND", "TEST 24", null, (short) 0));

        components.add(new Component(transistoren, manufacturer, distributor, null, "TEST SEMICOND", "TEST 25", null, (short) 0));
        components.add(new Component(transistoren, manufacturer, distributor, null, "TEST SEMICOND", "TEST 26", null, (short) 0));
        components.add(new Component(transistoren, manufacturer, distributor, null, "TEST SEMICOND", "TEST 27", null, (short) 0));
        components.add(new Component(transistoren, manufacturer, distributor, null, "TEST SEMICOND", "TEST 28", null, (short) 0));
        components.add(new Component(transistoren, manufacturer, distributor, null, "TEST SEMICOND", "TEST 29", null, (short) 0));
        components.add(new Component(transistoren, manufacturer, distributor, null, "TEST SEMICOND", "TEST 30", null, (short) 0));

        components.add(new Component(irSender, manufacturer, distributor, null, "TEST SEMICOND OPTO", "TEST 31", null, (short) 0));
        components.add(new Component(irSender, manufacturer, distributor, null, "TEST SEMICOND OPTO", "TEST 32", null, (short) 0));
        components.add(new Component(irSender, manufacturer, distributor, null, "TEST SEMICOND OPTO", "TEST 33", null, (short) 0));
        components.add(new Component(irSender, manufacturer, distributor, null, "TEST SEMICOND OPTO", "TEST 34", null, (short) 0));

        components.add(new Component(irReceiver, manufacturer, distributor, null, "TEST SEMICOND OPTO", "TEST 35", null, (short) 0));
        components.add(new Component(irReceiver, manufacturer, distributor, null, "TEST SEMICOND OPTO", "TEST 36", null, (short) 0));

        for (Component c : components) {
            componentDAO.save(c);
            createTestPrices(c);
        }
    }

    private void createTestPrices(Component component) {
        Price p1 = new Price(component, (short) 1, new BigDecimal("1"));
        Price p2 = new Price(component, (short) 50, new BigDecimal("1.2"));
        Price p3 = new Price(component, (short) 100, new BigDecimal("1.4"));

        priceDAO.save(p1);
        priceDAO.save(p2);
        priceDAO.save(p3);
    }

    public static void main(String[] args) {
        new CreateComponent().tryCreate();
    }

}
