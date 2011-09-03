package net.bachi.componentdb.integration.build;

/**
 * @author Andreas Bachmann
 */
public interface Creatable {
    public void tryCreate();
    public boolean isEmpty();
    public void create();
}
