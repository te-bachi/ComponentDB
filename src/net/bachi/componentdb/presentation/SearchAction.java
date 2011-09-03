package net.bachi.componentdb.presentation;

import net.bachi.componentdb.business.Pathway;
import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.business.model.CategoryComparator;
import net.bachi.componentdb.business.model.Component;
import net.bachi.componentdb.business.model.ComponentComparator;
import net.bachi.componentdb.integration.ComponentDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Andreas Bachmann
 */
public class SearchAction extends GenericAction {

    public String search() {
        String          searchText;
        String          match;
        ComponentDAO    componentDAO;
        List<Component> components;
        Pathway         pathway;

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

            session.put("components", components);
            session.put("pathway", new Pathway(components));
        }
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
}
