package net.bachi.componentdb.business.model;

import java.util.Comparator;

/**
 * @author Andreas Bachmann
 */
public class NameableComparator implements Comparator<Nameable> {
    public int compare(Nameable o1, Nameable o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
