package net.bachi.componentdb.presentation.action;

import com.opensymphony.xwork2.ActionSupport;
import net.bachi.componentdb.business.model.Category;
import net.bachi.componentdb.integration.CategoryDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class CategoryListAction extends ActionSupport {
    private CategoryDAO categoryDAO = DAOFactory.getInstance().getCategoryDAO();

    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

     public String execute() throws Exception {
        categories = categoryDAO.findAll();
        return SUCCESS;
    }
}
