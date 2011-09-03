package net.bachi.componentdb.business.model;

import java.util.Comparator;

/**
 * @author Andreas Bachmann
 */
public class ComponentComparator implements Comparator<Component> {
    public int compare(Component o1, Component o2) {
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
