package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.integration.CategoryDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class SelectCategory {
    public static void main(String[] args) {
        CategoryDAO categoryDAO = DAOFactory.getInstance().getCategoryDAO();

        List<Category> categories = categoryDAO.findAll();
        System.out.print("Select all categories: ");
        if (categories.size() > 0) {
            System.out.println("Data found!");
        } else {
            System.out.println("Data not found!");
        }

        Category c1 = categoryDAO.findById(29);

        if (c1 == null) {
            System.out.println("No data found!");
        } else {
            while (c1.getParentCategory() != null) {
                System.out.print(c1.getName() + " -> ");
                c1 = c1.getParentCategory();
            }

            System.out.print(c1.getName());
        }
    }
}
