package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.Pathway;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.CategoryComparator;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.ComponentComparator;
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
public class CreateCategoryTree {

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
     * @param componetMap Eine leere Map, die in der Methode gefüllt wird
     * @param categoryMap Eine leere Map, die in der Methode gefüllt wird
     * @return Gibt die Wurzel-Kategorie zurück
     */
    public static Category getPathway(List<Component> components,
                                      Map<Category, SortedSet<Component>> componetMap,
                                      Map<Category, SortedSet<Category>> categoryMap) {

        // Value für die Map
        SortedSet<Component> componentValueSet;
        SortedSet<Category>  categorValueSet;

        // Für jede Kategorie-Stufe ein eigenes Set
        SortedSet<Category> categorySet;
        SortedSet<Category> tmpSet;
        Iterator<Category>  iter;
        Category            key;
        Category            root;
        Category            parentCategory;

        root        = null;
        categorySet = new TreeSet<Category>(new CategoryComparator());
        tmpSet      = new TreeSet<Category>(new CategoryComparator());
        /**
         * Für jede Komponente die zugehörige Kategorie extrahieren,
         * die Kategorie mit der Komponente in die Map fükken
         * und die Kategorie in ein temporäres Set füllen
         */
        for (Component component : components) {
            key = component.getCategory();

            categorySet.add(key);

            componentValueSet = componetMap.get(key);
            if (componentValueSet == null) {
                componentValueSet = new TreeSet<Component>(new ComponentComparator());
                componetMap.put(key, componentValueSet);
            }
            componentValueSet.add(component);
        }

        // Für jede Kategorie die Anzahl Komponenten speichern
        for (Category category : componetMap.keySet()) {
            componentValueSet = componetMap.get(category);
            category.setComponentCount(componentValueSet.size());
        }

        while (categorySet.size() > 0) {
            for (Category category : categorySet) {
                // Gehe eine Hierarchiestufe höher
                parentCategory = category.getParentCategory();
                if (parentCategory != null) {
                    tmpSet.add(parentCategory);
                    categorValueSet = categoryMap.get(parentCategory);
                    if (categorValueSet == null) {
                        categorValueSet = new TreeSet<Category>(new CategoryComparator());
                        categoryMap.put(parentCategory, categorValueSet);
                    }
                    categorValueSet.add(category);
                // Wenn es die höchste Hierarchiestufe, gehe nicht weiter
                } else {
                    root = category;
                }
            }

            categorySet = tmpSet;
            tmpSet = new TreeSet<Category>(new CategoryComparator());
        }

        return root;
    }

    public static void printCategories(StringBuilder b, Category category, Map<Category, SortedSet<Category>> categoryMap, int spaceCount) {
        printSpace(b, spaceCount + 1);
        b.append("<li>");
        b.append(category.getName());

        int count = category.getComponentCount();
        if (count > 0) {
            b.append(" (" + count + ")");
        }
        b.append("</li>");
        b.append("\n");
        SortedSet<Category> categorySet = categoryMap.get(category);
        if (categorySet != null) {
            printSpace(b, spaceCount + 1);
            b.append("<ul>\n");
            for (Category c : categorySet) {
                printCategories(b, c, categoryMap, spaceCount + 1);
            }
            printSpace(b, spaceCount + 1);
            b.append("</ul>\n");
        }
    }

    public static void printSpace(StringBuilder b, int spaceCount) {
        for (int i = 0; i < spaceCount; i++) {
            b.append("    ");
        }
    }

    public static void main(String[] args) {
        /*
        List<Component>                     components;
        Category                            root;
        Map<Category, SortedSet<Component>> componentMap;
        Map<Category, SortedSet<Category>>  categoryMap;
        
        componentMap = new HashMap<Category, SortedSet<Component>>();
        categoryMap  = new HashMap<Category, SortedSet<Category>>();

        System.out.println("Get components from DB");
        components = getComponents();
        System.out.println("Done");

        System.out.println("Create category-tree");
        root = getPathway(components, componentMap, categoryMap);
        StringBuilder b = new StringBuilder();
        b.append("<ul>\n");
        printCategories(b, root, categoryMap, 0);
        b.append("</ul>\n");

        System.out.println(b);
        */

        Pathway p = new Pathway(getComponents());
        System.out.println(p.getCategoryTree());

    }
}
