package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.AttributeGroup;
import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.Distributor;
import net.bachi.componentdb.business.model.Manufacturer;
import net.bachi.componentdb.business.model.PartNumber;
import net.bachi.componentdb.business.model.Price;
import net.bachi.componentdb.integration.AttributeGroupDAO;
import net.bachi.componentdb.integration.CategoryDAO;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;
import net.bachi.componentdb.integration.DistributorDAO;
import net.bachi.componentdb.integration.ManufacturerDAO;
import net.bachi.componentdb.integration.PartNumberDAO;
import net.bachi.componentdb.integration.PriceDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Andreas Bachmann
 */
public class CreateComponent {

    private CategoryDAO categoryDAO;
    private ManufacturerDAO manufacturerDAO;
    private ComponentDAO componentDAO;
    private DistributorDAO distributorDAO;
    private PartNumberDAO partNumberDAO;
    private PriceDAO priceDAO;
    private AttributeGroupDAO attributeGroupDAO;

    public CreateComponent() {
        categoryDAO = DAOFactory.getInstance().getCategoryDAO();
        manufacturerDAO = DAOFactory.getInstance().getManufacturerDAO();
        componentDAO = DAOFactory.getInstance().getComponentDAO();
        distributorDAO = DAOFactory.getInstance().getDistributorDAO();
        partNumberDAO = DAOFactory.getInstance().getPartNumberDAO();
        priceDAO = DAOFactory.getInstance().getPriceDAO();
        attributeGroupDAO = DAOFactory.getInstance().getAttributeGroupDAO();
    }

    private void create74HC244() {
        Category category = categoryDAO.findByName("74er Logik");
        Manufacturer manufacturer = manufacturerDAO.findByName("Fairchild Semiconductor");

        Component component = new Component(category, manufacturer, "74HC244", "Logic-IC Octal 3-State Driver DIL-20", null, (short) 0);
        createLogikgatterValues(component);
        componentDAO.save(component);

        Distributor distributor = distributorDAO.findByName("Distrelec");
        PartNumber partNumber = new PartNumber("642663", component, distributor);
        partNumberDAO.save(partNumber);

        Price p1 = new Price(partNumber, (short) 1, new BigDecimal("1.19"));
        Price p2 = new Price(partNumber, (short) 25, new BigDecimal("0.97"));
        Price p3 = new Price(partNumber, (short) 100, new BigDecimal("0.81"));

        priceDAO.save(p1);
        priceDAO.save(p2);
        priceDAO.save(p3);

    }

    private void create74HC74() {
        Category category = categoryDAO.findByName("74er Logik");
        Manufacturer manufacturer = manufacturerDAO.findByName("Fairchild Semiconductor");

        Component component = new Component(category, manufacturer, "74HC74", "Logic-IC Dual D-Type FF DIL-14 ", null, (short) 5);
        createLogikgatterValues(component);
        componentDAO.save(component);

        Distributor distributor1 = distributorDAO.findByName("Distrelec");
        PartNumber partNumber1 = new PartNumber("643212", component, distributor1);
        partNumberDAO.save(partNumber1);

        Price p1 = new Price(partNumber1, (short) 1, new BigDecimal("0.65"));
        Price p2 = new Price(partNumber1, (short) 25, new BigDecimal("0.54"));
        Price p3 = new Price(partNumber1, (short) 100, new BigDecimal("0.43"));

        Distributor distributor2 = distributorDAO.findByName("Reichelt");
        PartNumber partNumber2 = new PartNumber("74HC 74", component, distributor2);
        partNumberDAO.save(partNumber2);

        Price p4 = new Price(partNumber2, (short) 1, new BigDecimal("0.18"));
        
        priceDAO.save(p1);
        priceDAO.save(p2);
        priceDAO.save(p3);
        priceDAO.save(p4);

    }

    private void create74HC74_2() {
        Category category = categoryDAO.findByName("74er Logik");
        Manufacturer manufacturer = manufacturerDAO.findByName("NXP");

        Component component = new Component(category, manufacturer, "74HC74", "Logic-IC Dual D-Type FF SO-14", null, (short) 10);
        createLogikgatterValues(component);
        componentDAO.save(component);

        Distributor distributor1 = distributorDAO.findByName("Distrelec");
        PartNumber partNumber1 = new PartNumber("649484", component, distributor1);
        partNumberDAO.save(partNumber1);

        Price p1 = new Price(partNumber1, (short) 1, new BigDecimal("0.59"));
        Price p2 = new Price(partNumber1, (short) 25, new BigDecimal("0.54"));
        Price p3 = new Price(partNumber1, (short) 100, new BigDecimal("0.43"));

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

    private void createKondensator() {
        //Component component = new Component();
    }

    public static void main(String[] args) {
        CreateComponent c = new CreateComponent();

        //c.create74HC244();
        //c.create74HC74();
        c.create74HC74_2();
    }

}
