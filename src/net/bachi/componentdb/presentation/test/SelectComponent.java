package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.Price;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class SelectComponent {
    public static void main(String[] args) {
        ComponentDAO componentDAO = DAOFactory.getInstance().getComponentDAO();

        List<Component> components = componentDAO.findAll();

        for (Component component : components) {
            System.out.println("=== " + component.getName() + " ===");
            System.out.println("Category: " + component.getCategory().getName());
            System.out.println("Desc:     " + component.getDescription());
            System.out.println("Place:    " + component.getPlace());
            System.out.println("Quantity: " + component.getQuantity());
            System.out.println();
            System.out.println("- Attribute -");
            for (AttributeValue attributeValue : component.getAttributeValues()) {
                System.out.println(attributeValue.getAttribute().getName() + ": " + attributeValue.getValue());
            }
            System.out.println();
            System.out.println("- Price -");
            /*
            for (PartNumber partNumber : component.getPartNumbers()) {
                String currency = partNumber.getDistributor().getCountry().getCurrency().getName();
                System.out.println(partNumber.getPartNumber() + " (" + partNumber.getDistributor().getName() + ")");
                for (Price price : partNumber.getPrices()) {
                    System.out.println(price.getQuantity() + "+: " + price.getPrice().toString() + " " + currency);
                }
                System.out.println("");
            }
            */
        }
    }
}
