package net.bachi.componentdb.presentation;

import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Andreas Bachmann
 */
public class CategoryAction extends GenericAction {


    private List<Component> components;
    private Map<Category, List<Component>> categories;

    @SuppressWarnings("unchecked")
    public String category() {

        restoreSession();

        components = (List<Component>) session.get("components");
        categories = (Map<Category, List<Component>>) session.get("categories");

        return SUCCESS;
    }
}
