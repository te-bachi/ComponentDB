package net.bachi.componentdb.presentation.test;

import net.bachi.componentdb.business.model.Attribute;
import net.bachi.componentdb.business.model.AttributeGroup;
import net.bachi.componentdb.integration.AttributeGroupDAO;
import net.bachi.componentdb.integration.DAOFactory;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class SelectAttribute {
    public static void main(String[] args) {
        AttributeGroupDAO attributeGroupDAO = DAOFactory.getInstance().getAttributeGroupDAO();

        List<AttributeGroup> attributeGroups = attributeGroupDAO.findAll();
        if (attributeGroups.size() > 0) {
            for (AttributeGroup attributeGroup : attributeGroups) {
                System.out.println("=== " + attributeGroup.getName() + " ===");
                List<Attribute> attributes = attributeGroup.getAttributes();
                for (Attribute attribute : attributes) {
                    System.out.println(attribute.getName());
                }
                System.out.println("");
            }

        } else {
            System.out.println("Data not found!");
        }
    }
}
