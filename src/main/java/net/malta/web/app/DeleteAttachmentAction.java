package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.model.Attachment;
import net.malta.model.Item;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;



public class DeleteAttachmentAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{



		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Attachment.class);
		criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
		
		if(StringUtils.isNotBlank(req.getParameter("itemid"))){
			Criteria criteriaItem = session
					.createCriteria(Item.class);
			criteriaItem.add(Restrictions.eq("id", Integer.valueOf(req.getParameter("itemid"))));
			Item item = (Item) criteriaItem.uniqueResult();
			item.setDefaultattachment(null);
			session.saveOrUpdate(item);
//			transaction.commit();
			session.flush();
		}


		Attachment attachment = (Attachment) criteria.uniqueResult();
		
		session.delete(attachment);
		transaction.commit();
		session.flush();


		
				new HTTPGetRedirection(req, res, req.getParameter("from"),req.getParameter("toid"));
		return null;

	}
	
	
}