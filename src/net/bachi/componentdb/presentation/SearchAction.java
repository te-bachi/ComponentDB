package net.bachi.componentdb.presentation;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Andreas Bachmann
 */
public class SearchAction extends GenericAction {

    private List<Component> components;
    private Map<Category, List<Component>> categories;
    private Map<Attribute, List<Component>> attributes;

    public String search() {
        String       searchText;
        String       match;
        ComponentDAO componentDAO;

        saveSession();

        searchText   = getSearchText();
        match        = getMatch();
        componentDAO = DAOFactory.getInstance().getComponentDAO();


        if (searchText != null && searchText.isEmpty() == false) {
            if (match.equals(MATCH_EXACT)) {
                components = componentDAO.findExact(getSearchText(), getCheck());
            } else if (match.equals(MATCH_WILDCARD)) {
                components = componentDAO.findWildcard(getSearchText(), getCheck());
            } else {
                components = null;
            }

            if (components != null) {
                session.put("components", components);
                categories = new HashMap<Category, List<Component>>();
                for (Component component : components) {
                    List<Component> list = categories.get(component.getCategory());
                    if (list == null) {
                        list = new ArrayList<Component>();
                        categories.put(component.getCategory(), list);
                    }
                    list.add(component);

                }
            }
        }
        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String category() {

        restoreSession();

        components = (List<Component>) session.get("components");

        return SUCCESS;
    }

    public String filter() {
        return SUCCESS;
    }

    public String result() {
        return SUCCESS;
    }


    @Override
    public void saveSession() {
        super.saveSession();

    }

    @Override
    public void restoreSession() {
        super.restoreSession();

    }

    @Override
    public void removeSession() {
        super.removeSession();
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Map<Category, List<Component>> getCategories() {
        return categories;
    }

    public void setCategories(Map<Category, List<Component>> categories) {
        this.categories = categories;
    }
}
