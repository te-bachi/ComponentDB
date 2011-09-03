package net.bachi.componentdb.integration.build;

/**
 * @author Andreas Bachmann
 */
public class CreateDatabase {
    public static void main(String[] args) {
        new CreateAttribute().tryCreate();
        new CreateCategory().tryCreate();
        new CreateManufacturer().tryCreate();
        new CreateDistributor().tryCreate();
        new CreateComponent().tryCreate();
    }
}
