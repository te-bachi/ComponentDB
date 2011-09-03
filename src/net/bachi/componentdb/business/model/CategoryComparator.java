package net.bachi.componentdb.business.model;

import java.util.Comparator;

/**
 * @author Andreas Bachmann
 */
public class CategoryComparator implements Comparator<Category> {
    public int compare(Category o1, Category o2) {
        int result;

        result = o1.getName().compareTo(o2.getName());
        if (result == 0) {
            if (o1.getId() == o2.getId()) {
                return 0;
            } else if (o1.getId() > o2.getId()) {
                    return -1;
            }
            return 1;
        }
        return result;
    }
}
