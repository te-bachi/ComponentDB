package net.bachi.componentdb.integration.hibernate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Bachmann
 */
public class ColumnTranslation {
    private static Map<String, String> translationMap;

    static {
        translationMap = new HashMap<String, String>();
        translationMap.put("bestellNr",    "c.partNumber");
        translationMap.put("name",         "c.name");
        translationMap.put("beschreibung", "c.description");
        translationMap.put("hersteller",   "m.name");
        translationMap.put("attribute",    "v.value");
    }

    public static String translate(String key) {
        return translationMap.get(key);
    }
}
