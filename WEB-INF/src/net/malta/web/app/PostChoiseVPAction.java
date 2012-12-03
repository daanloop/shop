package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.ChoiseForm;
import net.malta.model.Choise;
import net.malta.model.ChoiseImpl;
import net.malta.model.Purchase;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PostChoiseVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

		
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
//		Criteria criteria2 = session.createCriteria(Item.class);
//		criteria2.add(Restrictions.idEq(itemInt));
//		Item item = (Item) criteria2.uniqueResult();
//		choise.setItem(item);
		choise.setWp_posts_id(itemInt);
		
//		if(item.getStocknum()<=0){
//			new HTTPGetRedirection(req, res, "ShowPurchase.do", null ,"zerostock=true");
//			return null;
//		}
		
		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
	
		Criteria criteriaChoise = session.createCriteria(Choise.class);
		criteriaChoise.add(Restrictions.eq("wp_posts_id", itemInt));
		criteriaChoise.add(Restrictions.eq("purchase", purchase));
		Choise ch = (Choise) criteriaChoise.uniqueResult();
		if(ch == null) {
			choise.setPurchase(purchase);
			//choise.setPricewithtax(item.getPricewithtax());
			//////////////////////////////////here the codes to get the price of wp_post using wp_post_id 
			choise.setPricewithtax(getPriceOf(choise.getWp_posts_id(), session));
			choise.setName(getNameOf(choise.getWp_posts_id(), session));
			choise.setImg(getImgOf(choise.getWp_posts_id(), session));;
//			choise.setPricewithtax( ( item.getPricewithtax() + choise.getItem().getCarriage().getValue()) );
			if(choise.getOrdernum()==0)
				choise.setOrdernum(1);
			session.evict(purchase);
			session.refresh(purchase);
			
			//purchase.setTotal(purchase.getTotal() + choise.getPricewithtax() * choise.getOrdernum());
			purchase.setTotal(purchase.getTotal() + choise.getPricewithtax());
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(choise);
			session.saveOrUpdate(purchase);
			transaction.commit();
			session.flush();
		}
		
		new HTTPGetRedirection(req, res, "ShowPurchase.do", null);
		return null;

		
	}

	private String getImgOf(int wp_posts_id, Session session) {
		 SQLQuery query = session.createSQLQuery("SELECT meta_value rate FROM wp_postmeta where meta_key = 'rate' and post_id = " + wp_posts_id);
		 Object result = query.uniqueResult();
		 // TODO this sql should be changed to get the image url
		return "http://africaandleo.com/wp-content/uploads/2012/11/Catlalog_AL_FA12-306-Edit1.jpg";
	}

	private String getNameOf(int wp_posts_id, Session session) {
		 SQLQuery query = session.createSQLQuery("SELECT post_title rate FROM wp_posts where ID = " + wp_posts_id);
		 Object result = query.uniqueResult();

		 //TODO this sql should be changed to get the name of the product.
		return "Biker Leather";
	}

	private int getPriceOf(int wp_posts_id,Session session) {
		 SQLQuery query = session.createSQLQuery("SELECT meta_value rate FROM wp_postmeta where meta_key = 'rate' and post_id = " + wp_posts_id);
		 Object result = query.uniqueResult();
		 
		 //how to remove yen mark, and . mark in the middle.
		// TODO Auto-generated method stub 
		// here the codes to get the price of wp_post using wp_post_id
		 //now returning test price....
		return 500;
	}
	
	
}