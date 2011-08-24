package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Attachment;
import net.bachi.componentdb.integration.AttachmentDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttachmentDAOHibernate extends GenericDAOHibernate<Attachment, Integer> implements AttachmentDAO {
    public List<Attachment> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
