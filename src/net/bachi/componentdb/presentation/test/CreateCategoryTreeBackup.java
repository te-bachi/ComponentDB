package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.CategoryComparator;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.Nameable;
import net.bachi.componentdb.business.model.NameableComparator;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Andreas Bachmann
 */
public class CreateCategoryTreeBackup {

    public static List<Component> getComponents() {
        ComponentDAO        componentDAO;
        Map<String, String> check;

        componentDAO = DAOFactory.getInstance().getComponentDAO();
        check = new HashMap<String, String>();
        check.put("name", "true");
        return componentDAO.findWildcard("TEST", check);
    }

    /**
     *
     * @param components Eine volle Liste mit Komponenten
     * @param categoryMap Eine leere Map, die in der Methode gefüllt wird
     * @return Gibt die Wurzel-Kategorie zurück
     */
    public static Category getPathway(List<Component> components, Map<Category, SortedSet<Nameable>> categoryMap) {
        // Value für die Map
        SortedSet<Nameable> valueSet;

        // Für jede Kategorie-Stufe ein eigenes Set
        SortedSet<Category> categorySet;
        SortedSet<Category> tmp;
        Iterator<Category>  iter;
        Category            category;
        Category            root;
        Category            parentCategory;

        root       = null;
        categorySet = new TreeSet<Category>(new CategoryComparator());
        tmp         = new TreeSet<Category>(new CategoryComparator());
        /**
         * Für jede Komponente die zugehörige Kategorie extrahieren,
         * die Kategorie mit der Komponente in die Map fükken
         * und die Kategorie in ein temporäres Set füllen
         */
        for (Component component : components) {
            category = component.getCategory();

            //
            categorySet.add(category);

            valueSet = categoryMap.get(category);
            if (valueSet == null) {
                valueSet = new TreeSet<Nameable>(new NameableComparator());
                categoryMap.put(category, valueSet);
            }
            //valueSet.add(component);
        }

        while (categorySet.size() > 0) {
            iter = categorySet.iterator();
            while (iter.hasNext()) {
                category = iter.next();

                // Gehe eine Hierarchiestufe höher
                parentCategory = category.getParentCategory();
                if (parentCategory != null) {
                    tmp.add(parentCategory);
                    valueSet = categoryMap.get(parentCategory);
                    if (valueSet == null) {
                        valueSet = new TreeSet<Nameable>(new NameableComparator());
                        categoryMap.put(parentCategory, valueSet);
                    }
                    //valueSet.add(category);
                // Wenn es die höchste Hierarchiestufe, gehe nicht weiter
                } else {
                    root = category;
                }
            }
            categorySet = tmp;
            tmp         = new TreeSet<Category>(new CategoryComparator());
        }

        return root;
    }

    public static void main(String[] args) {
        List<Component>                     components;
        Category                            root;
        Map<Category, SortedSet<Nameable>>  categoryMap;
        System.out.println("Get Components from DB");
        components = getComponents();
        System.out.println("Done");
        /*
        System.out.println("Root Category: '" + root.getName() + "'");

        categories = categoryListMap.get(root);
        while (categories != null) {

        }
        */

    }
}
