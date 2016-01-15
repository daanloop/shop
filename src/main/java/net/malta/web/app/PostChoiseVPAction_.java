package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.StringFullfiller;
import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PostChoiseVPAction_ extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		if(req.getScheme().equals("http")) {
//			res.sendRedirect("https://www.malta-net.jp/PostChoiseVP.do?item=" + req.getParameter("item"));
//	res.sendRedirect("https://www.akaruiheya.com/PostChoiseVP.do?item=" + req.getParameter("item"));
			res.sendRedirect("http://africaandleo.com/shop/PostChoiseVP.do?item=" + req.getParameter("item"));
	//	res.sendRedirect("https://localhost:8443/akaruiheya/PostChoiseVP.do?item=" + req.getParameter("item"));
			return null;
		}else{
			System.err.println("not http. the scheme is " + req.getScheme());
		}

		
		Choise choise = new ChoiseImpl();
		ChoiseForm choiseform = (ChoiseForm) form;

                String error = "";


        Integer purchaseInt = choiseform.getPurchase();
		choiseform.setPurchase(null);
		Integer itemInt = choiseform.getItem();
		choiseform.setItem(null);

		
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		
		

		
		if(choiseform.getId() == null || choiseform.getId().intValue() == 0){
			choise.setId(null);
			choiseform.setId(null);
		}else{
			choise.setId(choiseform.getId());
			Criteria criteria = session.createCriteria(Choise.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			choise = (Choise) criteria.uniqueResult();

		}
		choise.setOrdernum(choiseform.getOrdernum());
		choise.setPricewithtax(choiseform.getPricewithtax());
		choise.setWrapping(choiseform.isWrapping());
		
		StringFullfiller.fullfil(choise);
        
//		criteria2.add(Restrictions.idEq(purchaseInt));
//		Purchase purchase = (Purchase) criteria2.uniqueResult();
//		choise.setPurchase(purchase);
		Criteria criteria2 = session.createCriteria(Item.class);
		criteria2.add(Restrictions.idEq(itemInt));
		Item item = (Item) criteria2.uniqueResult();
		choise.setItem(item);
		
		if(item.getStocknum()<=0){
			new HTTPGetRedirection(req, res, "ShowPurchase.do", null ,"zerostock=true");
			return null;
		}
		
		
		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		
		
		
		Criteria criteriaChoise = session.createCriteria(Choise.class);
		criteriaChoise.add(Restrictions.eq("item", item));
		criteriaChoise.add(Restrictions.eq("purchase", purchase));
		Choise ch = (Choise) criteriaChoise.uniqueResult();
		if(ch == null) {
			choise.setPurchase(purchase);
			choise.setPricewithtax( ( item.getPricewithtax() + choise.getItem().getCarriage().getValue() )  * choise.getOrdernum());
			if(choise.getOrdernum()==0)
				choise.setOrdernum(1);
			session.evict(purchase);
			session.refresh(purchase);
			
			purchase.setTotal(purchase.getTotal() + choise.getPricewithtax());
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(choise);
			session.saveOrUpdate(purchase);
			transaction.commit();
			session.flush();
		}
		
		
//		new HTTPGetRedirection(req, res, "PostProductDetail.do.do", choise.getId().toString());
		new HTTPGetRedirection(req, res, "ShowPurchase.do", null);
		return null;

		
	}
	
	
}