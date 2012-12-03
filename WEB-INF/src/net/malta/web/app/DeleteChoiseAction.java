package net.malta.web.app;

import java.util.Iterator;

import net.malta.model.*;
import net.malta.model.crud.*;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.enclosing.util.HibernateSession;



public class DeleteChoiseAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{



		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Choise.class);
		criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));

		Choise choise = (Choise) criteria.uniqueResult();
		session.delete(choise); 
		transaction.commit();
		session.flush();
		
		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		session.evict(purchase);
		session.refresh(purchase);
		int total = 0;
		for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
			Choise choise2 = (Choise) iterator.next();
			total += choise2.getPricewithtax();
//			total += choise2.getPricewithtax() * choise2.getOrdernum();
		}
		
//		PurchaseForm purchaseform = new PurchaseForm();
//		Criteria criteria = session.createCriteria(Purchase.class);
//
//		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
//			criteria.add(Restrictions.idEq(Integer.valueOf(req
//					.getParameter("id"))));
//			purchase = (Purchase) criteria.uniqueResult();
//			new CopyProperties(purchase,purchaseform);
//		} else if(req.getAttribute("form")!=null){
//                        purchaseform = (PurchaseForm)req.getAttribute("form");
//			criteria.add(Restrictions.idEq(purchaseform.getId()));
//			purchase = (Purchase) criteria.uniqueResult();
//		}
//                   
		purchase.setTotal(total);
		transaction = session.beginTransaction();
		session.saveOrUpdate(purchase);
		transaction.commit();
		session.flush();

		new HTTPGetRedirection(req, res, "ShowPurchase.do",null);
		return null;
	}
}