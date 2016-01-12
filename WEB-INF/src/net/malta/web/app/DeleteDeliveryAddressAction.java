package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.model.DeliveryAddress;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DeleteDeliveryAddressAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		
		if(req.getParameter("id")==null || req.getParameter("id").equals("")) {
			new HTTPGetRedirection(req, res, "DeliveryAddressList.html",null);
			return null;
		}

		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(DeliveryAddress.class);
		criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));

		DeliveryAddress deliveryAddress = (DeliveryAddress) criteria.uniqueResult();
		session.delete(deliveryAddress);
		transaction.commit();
		session.flush();

		new HTTPGetRedirection(req, res, "DeliveryAddressList.html",null);
		return null;
	}
}