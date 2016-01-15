package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;
import net.storyteller.desktop.CopyProperties;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.StringFullfiller;
import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.poi.poifs.property.Child;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UpdatePurchaseForTotalAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{


		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		
		
		

		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		session.evict(purchase);
		session.refresh(purchase);
		int total = 0;
		for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
			Choise choise = (Choise) iterator.next();
			int value = Integer.parseInt(req.getParameter("ordernum_"+choise.getId()));
			choise.setOrdernum(value);
			choise.setPricewithtax((choise.getItem().getPricewithtax() * choise.getOrdernum())+ choise.getItem().getCarriage().getValue());
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(choise);
			transaction.commit();
			session.flush();
			total += (choise.getItem().getPricewithtax() * choise.getOrdernum())+ choise.getItem().getCarriage().getValue();
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
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(purchase);
		transaction.commit();
		session.flush();

		new HTTPGetRedirection(req, res, "ShowPurchase.html",null);
		return null;
	}
	
}