package net.malta.web.app;

import net.malta.model.*;
import net.malta.web.utils.DeliveryMethodUtils;
import net.malta.web.utils.SessionData;
import net.malta.beans.*;
import net.storyteller.desktop.CopyProperties;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.StringFullfiller;
import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;

import net.malta.model.GiftCard;
import net.malta.model.Prefecture;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.malta.model.Purchase;

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


public class UpdateCarriageForPrefectureAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

         DeliveryMethodUtils.setIntoSesssion(req);
		
		PublicUser publicUser = new PublicUserImpl();
		PublicUserForm publicUserform = (PublicUserForm) form;

		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		
		
		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		session.evict(purchase);
		session.refresh(purchase);
		
		Map map = new HashMap();
		map.put(new Integer(1), new Integer(1060));
		map.put(new Integer(2), new Integer(740));
		map.put(new Integer(3), new Integer(740));
		map.put(new Integer(4), new Integer(640));
		map.put(new Integer(5), new Integer(740));
		
		map.put(new Integer(6), new Integer(640));
		map.put(new Integer(7), new Integer(640));
		map.put(new Integer(8), new Integer(640));
		map.put(new Integer(9), new Integer(640));
		map.put(new Integer(10), new Integer(640));
		map.put(new Integer(11), new Integer(640));
		map.put(new Integer(12), new Integer(640));
		map.put(new Integer(13), new Integer(640));
		map.put(new Integer(14), new Integer(640));
		map.put(new Integer(15), new Integer(640));
		map.put(new Integer(16), new Integer(640));
		map.put(new Integer(17), new Integer(640));
		map.put(new Integer(18), new Integer(640));
		
		map.put(new Integer(19), new Integer(640)); // yamanashi
		map.put(new Integer(20), new Integer(640)); // nagano
		map.put(new Integer(21), new Integer(640)); // gifu
		map.put(new Integer(22), new Integer(640)); // Shizuoka
		map.put(new Integer(23), new Integer(640)); // Aichi
		map.put(new Integer(24), new Integer(640)); // Mie
		map.put(new Integer(25), new Integer(740)); // Shiga
		map.put(new Integer(26), new Integer(740)); // Kyoto
		map.put(new Integer(27), new Integer(740)); // Osaka
		map.put(new Integer(28), new Integer(740)); // Hyogo
		map.put(new Integer(29), new Integer(740)); // Naara
		map.put(new Integer(30), new Integer(740)); // Wakayama
		
		map.put(new Integer(31), new Integer(850)); // Tottori
		map.put(new Integer(32), new Integer(850)); // Shimane
		map.put(new Integer(33), new Integer(850)); // Okayama
		map.put(new Integer(34), new Integer(850)); // Hiroshima
		map.put(new Integer(35), new Integer(850)); // Yamaguchi
		
		map.put(new Integer(36), new Integer(950)); // Tokushima
		map.put(new Integer(37), new Integer(950)); // Kagawa
		map.put(new Integer(38), new Integer(950)); // Ehime
		map.put(new Integer(39), new Integer(950)); // kochi
		map.put(new Integer(40), new Integer(1060)); // fukuoka
		map.put(new Integer(41), new Integer(1060)); // saga
		map.put(new Integer(42), new Integer(1060)); // nagasaki
		map.put(new Integer(43), new Integer(1060)); // kumamoto
		map.put(new Integer(44), new Integer(1060)); // oita
		map.put(new Integer(45), new Integer(1060)); // miyazaki
		map.put(new Integer(46), new Integer(1060)); // kagoshima
		map.put(new Integer(47), new Integer(1160)); // Okinawa
		
		int total = 0;
		for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
			Choise choise = (Choise) iterator.next();
		
		    Integer key=publicUserform.getPrefecture();
		 
	        int value=(Integer) map.get(key);
			choise.getItem().getCarriage().setValue(value);
			
			/*int value = Integer.parseInt(req.getParameter("ordernum_"+choise.getId()));
			choise.setOrdernum(value);*/
			choise.setPricewithtax( ( choise.getItem().getPricewithtax() + choise.getItem().getCarriage().getValue()) * choise.getOrdernum());
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(choise);
			transaction.commit();
			session.flush();
			total += choise.getPricewithtax();
//			total += choise.getItem().getPricewithtax() * choise.getOrdernum() + choise.getItem().getCarriage().getValue()*choise.getOrdernum();
			
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
		
		publicUser.setName(publicUserform.getName());
		publicUser.setKana(publicUserform.getKana());
		publicUser.setZipthree(publicUserform.getZipthree());
		publicUser.setZipfour(publicUserform.getZipfour());
		publicUser.setMailforconfirm(publicUserform.getMailforconfirm());
		publicUser.setMail(publicUserform.getMail());
		publicUser.setAddress(publicUserform.getAddress());
		publicUser.setBuildingname(publicUserform.getBuildingname());
		publicUser.setFax(publicUserform.getFax());
		publicUser.setPhone(publicUserform.getPhone());
		if(!publicUser.isRegisted()){
			publicUser.setPassword(publicUserform.getPassword());
			publicUser.setRegisted(publicUserform.isRegisted());
		}
		publicUser.setTemp(new Boolean(false));
		publicUser.setHasgiftcard(publicUserform.isHasgiftcard());
		publicUser.setPreferredtime(publicUserform.getPreferredtime());
		publicUser.setPref(publicUserform.getPref());
		publicUser.setPreferreddatedate(publicUserform.getPreferreddatedate());
		StringFullfiller.fullfil(publicUser);
                
		Integer prefectureInt = publicUserform.getPrefecture();
		publicUserform.setPrefecture(null);
		Integer giftcardInt = publicUserform.getGiftCard();
		publicUserform.setGiftCard(null);
		
		Criteria criteria2 = session.createCriteria(Prefecture.class);
		criteria2.add(Restrictions.idEq(prefectureInt));
		Prefecture prefecture = (Prefecture) criteria2.uniqueResult();
		publicUser.setPrefecture(prefecture);
		criteria2 = session.createCriteria(GiftCard.class);
		criteria2.add(Restrictions.idEq(giftcardInt));
		GiftCard giftcard = (GiftCard) criteria2.uniqueResult();
		publicUser.setGiftCard(giftcard);
		purchase.setTotal(total);
		
		Transaction transaction = session.beginTransaction();
		
		session.saveOrUpdate(purchase);
		session.saveOrUpdate(publicUser);
		transaction.commit();
		session.flush();
		
		session.evict(publicUser);

		//updating this publicUser into sessssion ,cookie  and purchase.setThisPublicUser(). also
		//Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		//session.evict(purchase);
//		session.close();
		SessionData.update(publicUser, purchase, req, res,session);	

		new HTTPGetRedirection(req, res, "PostPublicUserDetail.do",null);
		return null;
	}
	
}