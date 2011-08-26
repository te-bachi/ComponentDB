package net.bachi.componentdb.integration.hibernate;

import net.bachi.componentdb.business.model.Attachment;
import net.bachi.componentdb.integration.AttachmentDAO;

import java.util.List;

/**
 * @author Andreas Bachmann
 */
public class AttachmentDAOHibernate extends GenericDAOHibernate<Attachment, Integer> implements AttachmentDAO {
    @SuppressWarnings("unchecked")
    public List<Attachment> findAll() {
        return HibernateUtil.getManager().createQuery("select a from Attachment a").getResultList();
    }
}
