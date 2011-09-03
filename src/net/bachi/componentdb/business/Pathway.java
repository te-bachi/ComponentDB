package net.bachi.componentdb.business;

import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.CategoryComparator;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.ComponentComparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Andreas Bachmann
 */
public class Pathway {

    private Map<Category, SortedSet<Component>> componentMap;
    private Map<Category, SortedSet<Category>>  categoryMap;
    private Category                            root;

    /**
     * @param components Eine volle Liste mit Komponenten
     */
    public Pathway(List<Component> components) {

        // Value für die Map
        SortedSet<Component> componentValueSet;
        SortedSet<Category>  categorValueSet;

        // Für jede Kategorie-Stufe ein eigenes Set
        SortedSet<Category> categorySet;
        SortedSet<Category> tmpSet;
        Category            key;
        Category            parentCategory;

        root         = null;
        categorySet  = new TreeSet<Category>(new CategoryComparator());
        tmpSet       = new TreeSet<Category>(new CategoryComparator());

        componentMap = new HashMap<Category, SortedSet<Component>>();
        categoryMap  = new HashMap<Category, SortedSet<Category>>();

        /**
         * Für jede Komponente die zugehörige Kategorie extrahieren,
         * die Kategorie mit der Komponente in die Map fükken
         * und die Kategorie in ein temporäres Set füllen
         */
        for (Component component : components) {
            key = component.getCategory();

            categorySet.add(key);

            componentValueSet = componentMap.get(key);
            if (componentValueSet == null) {
                componentValueSet = new TreeSet<Component>(new ComponentComparator());
                componentMap.put(key, componentValueSet);
            }
            componentValueSet.add(component);
        }

        // Für jede Kategorie die Anzahl Komponenten speichern
        for (Category category : componentMap.keySet()) {
            componentValueSet = componentMap.get(category);
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
    }

    public String getCategoryTree() {
        StringBuilder b;

        b = new StringBuilder();
        b.append("<ul>\n");
        getCategoryTree(b, root, 0);
        b.append("</ul>\n");

        return b.toString();
    }

    private void getCategoryTree(StringBuilder b, Category category, int spaceCount) {
        printSpace(b, spaceCount + 1);
        b.append("<li>");
        b.append(category.getName());

        int count = category.getComponentCount();
        if (count > 0) {
            b.append(" (");
            b.append(count);
            b.append(")");
        }
        b.append("</li>");
        b.append("\n");
        SortedSet<Category> categorySet = categoryMap.get(category);
        if (categorySet != null) {
            printSpace(b, spaceCount + 1);
            b.append("<ul>\n");
            for (Category c : categorySet) {
                getCategoryTree(b, c, spaceCount + 1);
            }
            printSpace(b, spaceCount + 1);
            b.append("</ul>\n");
        }
    }

    private void printSpace(StringBuilder b, int spaceCount) {
        for (int i = 0; i < spaceCount; i++) {
            b.append("    ");
        }
    }

    public Map<Category, SortedSet<Component>> getComponentMap() {
        return componentMap;
    }

    public Map<Category, SortedSet<Category>> getCategoryMap() {
        return categoryMap;
    }
}
