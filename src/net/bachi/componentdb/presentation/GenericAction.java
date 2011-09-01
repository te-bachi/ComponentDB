package net.bachi.componentdb.presentation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Bachmann
 */
public class GenericAction extends ActionSupport implements SessionAware{

    public static final String SESSION_SEARCHTEXT   = "searchText";
    public static final String SESSION_MATCH        = "match";
    public static final String SESSION_CHECK        = "check";
    public static final String SESSION_BREADCRUMBS  = "breadcrumbs";

    public static final String MATCH_EXACT = "exact";
    public static final String MATCH_WILDCARD = "wildcard";

    protected Map<String, Object> session;

    private String searchText;
    private String match;
    private Map<String, String> check = new HashMap<String, String>();
    private String breadcrumbs;

    @SuppressWarnings("unchecked")
    public void saveSession() {
        session.put(SESSION_SEARCHTEXT, searchText);
        session.put(SESSION_MATCH, match);
        session.put(SESSION_CHECK, check);
        session.put(SESSION_BREADCRUMBS, breadcrumbs);

    }

    @SuppressWarnings("unchecked")
    public void restoreSession() {
        searchText  = (String) session.get(SESSION_SEARCHTEXT);
        match       = (String) session.get(SESSION_MATCH);
        check       = (Map<String, String>) session.get(SESSION_CHECK);
        breadcrumbs = (String) session.get(SESSION_BREADCRUMBS);
    }

    public void removeSession() {
        session.remove(SESSION_SEARCHTEXT);
        session.remove(SESSION_MATCH);
        session.remove(SESSION_CHECK);
        session.remove(SESSION_BREADCRUMBS);
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getMatchDefault() {
        return MATCH_EXACT;
    }

    public Map<String, String> getCheck() {
        return check;
    }

    public void setCheck(Map<String, String> check) {
        this.check = check;
    }

    public String getBreadcrumbs() {
        return breadcrumbs;
    }

    public void setBreadcrumbs(String breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }
}
