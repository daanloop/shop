package net.malta.web.app;

import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.PurchaseForm;
import net.malta.model.Choise;
import net.malta.model.Item;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.malta.model.Purchase;
import net.malta.model.PurchaseImpl;
import net.malta.web.utils.SessionData;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.taglib.tiles.GetAttributeTag;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PostPurchaseVPForSettingNonTempAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.err.println("mark 3, navigated to ForSettingNonTemp.");

		Purchase purchase = new PurchaseImpl();
		PurchaseForm purchaseform = (PurchaseForm) form;

		String error = "";
		if (StringUtils.isNotBlank(error)) {
			req.getSession().setAttribute("error", error);
			req.setAttribute("form", purchaseform);
			return mapping.findForward("error");
		}
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext(),120);
		
		purchase = (Purchase)req.getSession().getAttribute("purchase");
		Criteria criteriaPurchase = session.createCriteria(Purchase.class);
		criteriaPurchase.add(Restrictions.eq("id", purchase.getId()));
		purchase = (Purchase) criteriaPurchase.uniqueResult();
		
		if(purchase == null){
			if (purchaseform.getId() == null
					|| purchaseform.getId().intValue() == 0) {
				purchase.setId(null);
				purchaseform.setId(null);
			} else {
				purchase.setId(purchaseform.getId());
				Criteria criteria = session.createCriteria(Purchase.class);
				criteria.add(Restrictions.idEq(Integer.valueOf(req
						.getParameter("id"))));
				purchase = (Purchase) criteria.uniqueResult();

			}
		}
		
		System.err.println("mark 5, setting NonTemp.");
		purchase.setTemp(purchaseform.isTemp());
		purchase.setPublicUser((PublicUser)req.getSession().getAttribute("u"));

		StringFullfiller.fullfil(purchase);
		session.evict(purchase);
		session.clear();

		Transaction transaction = session.beginTransaction();
		purchase.setDate(new Date());
		session.saveOrUpdate(purchase);
		transaction.commit();
		session.flush();
		
//		for (Iterator iter = purchase.getChoises().iterator(); iter.hasNext();) {
//			Choise ch = (Choise) iter.next();
//			Criteria criteriaItem = session.createCriteria(Item.class);
//			criteriaItem.add(Restrictions.idEq(ch.getItem().getId()));
//			Item item = (Item) criteriaItem.uniqueResult();
//			item.setStocknum((item.getStocknum()-ch.getOrdernum()));
//			
//			transaction = session.beginTransaction();
//			session.saveOrUpdate(item);
//			transaction.commit();
//			session.flush();
//		}
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message", "success");
			return mapping.findForward("success");
		}

		if (StringUtils.isNotBlank(req.getParameter("from"))
				&& !req.getParameter("from").equals("")) {
			new HTTPGetRedirection(req, res, "PostPurchaseDetail.html", purchase
					.getId().toString());
			return null;
		}
		
//		if(StringUtils.isNotBlank(req.getParameter("deliverymethod"))){
//			int deliverymethod = Integer.parseInt(req.getParameter("deliverymethod"));
//			MailAboutPurchaseToPublicUserAction aboutPurchaseToPublicUserAction 
//			= new  MailAboutPurchaseToPublicUserAction();
//			aboutPurchaseToPublicUserAction.execute(purchase.getId(),session,deliverymethod);
//		}else{
//			Integer deliverymethodInt = (Integer)req.getSession().getAttribute("deliverymethod");
			MailAboutPurchaseToPublicUserAction aboutPurchaseToPublicUserAction 
			= new  MailAboutPurchaseToPublicUserAction();
			aboutPurchaseToPublicUserAction.execute(purchase.getId(),session,1);
//		}
//		MailAboutPurchaseToAdminAction aboutPurchaseToAdminAction 
//		= new  MailAboutPurchaseToAdminAction();
//		aboutPurchaseToAdminAction.execute(purchase.getId(),session);
		

		purchase = new PurchaseImpl();
		purchase.setTemp(true);
		purchase.setPublicUser((PublicUser)req.getSession().getAttribute("u"));
		StringFullfiller.fullfil(purchase);
		
		transaction = session.beginTransaction();
		session.save(purchase);
		PublicUser publicUser = (PublicUser)req.getSession().getAttribute("u");
//		publicUser.setTemp(true);
//		StringFullfiller.fullfil(publicUser);
//		session.saveOrUpdate(publicUser);
		Purchase purchase2 = new PurchaseImpl();
		StringFullfiller.fullfil(purchase2);
		purchase2.setTemp(true);
		purchase2.setPublicUser(publicUser);
		session.saveOrUpdate(purchase2);
		transaction.commit();
		session.flush();
		req.getSession().setAttribute("purchase", purchase2);
		SessionData.update(publicUser,purchase2,req, res,session);

		System.err.println("mark 6, navigated to ForSettingNonTemp.");
		new HTTPGetRedirection(req, res, "ShowPurchaseForThanks.html");
		return null;
	}
}