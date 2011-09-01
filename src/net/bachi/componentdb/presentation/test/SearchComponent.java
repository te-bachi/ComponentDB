package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.AttributeValue;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.PartNumber;
import net.bachi.componentdb.business.model.Price;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class SearchComponent {
    public static void main(String[] args) {
        ComponentDAO componentDAO = DAOFactory.getInstance().getComponentDAO();

        List<Component> components = null;

        //components= componentDAO.findExact("74HC74");
        System.out.println("=== Search: '74HC74' (exact) ===" );
        for (Component component : components) {
            System.out.println(component.getName() + " (" + component.getManufacturer().getName() + ")");
        }
        System.out.println();

        //components = componentDAO.findExact("642663");
        System.out.println("=== Search: '642663' (exact) ===" );
        for (Component component : components) {
            System.out.println(component.getName() + " (" + component.getManufacturer().getName() + ")");
        }
        System.out.println();

        //components = componentDAO.findWildcard("74");
        System.out.println("=== Search: '74' (wildcard) ===" );
        for (Component component : components) {
            System.out.println(component.getName() + " (" + component.getManufacturer().getName() + ")");
        }
        System.out.println();

    }
}
