package net.malta.web.app;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.PublicUserForm;
import net.malta.model.Choise;
import net.malta.model.Prefecture;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.malta.model.Purchase;
import net.malta.web.utils.SessionData;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PostPublicUserVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		
		
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
		
		
		PublicUser publicUser = new PublicUserImpl();
		PublicUserForm publicUserform = (PublicUserForm) form;

        String error = "";
		if(StringUtils.isBlank(publicUserform.getName())){
		   error += "名前は空にはできません。<br />"; 
		}
		
		if(StringUtils.isBlank(publicUserform.getKana())){
		   error += "カナは空にはできません。<br />"; 
		}
		
//		if(StringUtils.isBlank(req.getParameter("zipthree"))){
//		   error += "郵便番号3桁は空にはできません。<br />"; 
//		}
//		
//		if(!StringUtils.isNumeric(req.getParameter("zipthree"))){
//		    error += "郵便番号3桁には数値のみを入れてください。<br />";
//		}
		if(StringUtils.isBlank(req.getParameter("zipfour"))){
		   error += "郵便番号4桁は空にはできません。<br />"; 
		}
		
		if(!StringUtils.isNumeric(req.getParameter("zipfour"))){
		    error += "郵便番号4桁には数値のみを入れてください。<br />";
		}
		if(StringUtils.isBlank(publicUserform.getMail())){
		   error += "メールは空にはできません。<br />"; 
		}
		
		if(StringUtils.isBlank(publicUserform.getAddress())){
		   error += "アドレスは空にはできません。<br />"; 
		}

		if(!StringUtils.isNumeric(req.getParameter("fax"))){
		    error += "faxには数値のみを入れてください。<br />";
		}
		if(StringUtils.isBlank(publicUserform.getPhone())){
		   error += "電話番号は空にはできません。<br />"; 
		}
		
		if(!StringUtils.isNumeric(req.getParameter("phone"))){
		    error += "電話番号には数値のみを入れてください。<br />";
		}
		if(StringUtils.isNotBlank(error)){
			req.getSession().setAttribute("error",error);
			req.setAttribute("form",publicUserform);
			return mapping.findForward("error");
		}
		

		Integer prefectureInt = publicUserform.getPrefecture();
		publicUserform.setPrefecture(null);
		
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		if(publicUserform.getId() == null || publicUserform.getId().intValue() == 0){
			publicUser.setId(null);
			publicUserform.setId(null);
		}else{
			publicUser.setId(publicUserform.getId());
			Criteria criteria = session.createCriteria(PublicUser.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			publicUser = (PublicUser) criteria.uniqueResult();

		}
		
		publicUser.setName(publicUserform.getName());
		publicUser.setKana(publicUserform.getKana());
		publicUser.setZipthree(publicUserform.getZipthree());
		publicUser.setZipfour(publicUserform.getZipfour());
		publicUser.setMailforconfirm(publicUserform.getMailforconfirm());
		publicUser.setMail(publicUserform.getMail());
		publicUser.setAddress(publicUserform.getAddress());
		publicUser.setBuildingname(publicUserform.getBuildingname());
		publicUser.setRegisted(publicUserform.isRegisted());
		publicUser.setFax(publicUserform.getFax());
		publicUser.setPhone(publicUserform.getPhone());
		publicUser.setPassword(publicUserform.getPassword());
		publicUser.setTemp(new Boolean(false));
		StringFullfiller.fullfil(publicUser);
                
		
		Criteria criteria2 = session.createCriteria(Prefecture.class);
		criteria2.add(Restrictions.idEq(prefectureInt));
		Prefecture prefecture = (Prefecture) criteria2.uniqueResult();
		publicUser.setPrefecture(prefecture);

	    Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
	    session.evict(purchase);
		session.refresh(purchase);
	    Integer key=prefectureInt;//publicUserform.getPrefecture();
        int value=(Integer) map.get(key);
        
        value=value>20000?0:value;
        
        purchase.setCarriage(value);
		
		int total = 0;
		for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
			Choise choise = (Choise) iterator.next();
		
		   	 
	        
	        //please add carriage to choise.
			choise.setCarriage(0);
			
			/*int value = Integer.parseInt(req.getParameter("ordernum_"+choise.getId()));
			choise.setOrdernum(value);*/
			//choise.setPricewithtax( ( choise.getItem().getPricewithtax() + choise.getItem().getCarriage().getValue()) * choise.getOrdernum());
			choise.setPricewithtax((choise.getPricewithtax())+ choise.getCarriage());
			//Transaction transaction = session.beginTransaction();
		    Transaction	transaction = session.beginTransaction();
			session.saveOrUpdate(choise);
			transaction.commit();
			session.flush();
		//	total += choise.getPricewithtax();
//			total += choise.getItem().getPricewithtax() * choise.getOrdernum() + choise.getItem().getCarriage().getValue()*choise.getOrdernum();
			total += (choise.getPricewithtax())+ choise.getCarriage();	
		}
		
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(publicUser);
		session.saveOrUpdate(purchase);
		transaction.commit();
		session.flush();
		session.evict(publicUser);

		//updating this publicUser into sessssion ,cookie  and purchase.setThisPublicUser(). also
		//Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		//session.evict(purchase);
		//session.close();
		
	
		SessionData.update(publicUser, purchase, req, res,session);
		
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message","success");
			return mapping.findForward("success");
		}
		//new HTTPGetRedirection(req, res, "Login.do", null, "mail="+publicUser.getMail()+"&password="+publicUser.getPassword());
		if (StringUtils.isNotBlank(req.getParameter("from"))
				&& !req.getParameter("from").equals("")) {
			new HTTPGetRedirection(req, res, "PostPublicUserDetail.do", publicUser.getId().toString());
			return null;
		}else{
			new HTTPGetRedirection(req, res, "ShowPurchaseForConfirmation.do", null, "deliverymethod="+req.getParameter("deliverymethod"));
			return null;
		}
//		
//		if(StringUtils.isNotBlank(req.getParameter("deliverymethod"))){
//			if(req.getParameter("deliverymethod").equals("1")){
//				new HTTPGetRedirection(req, res, "ShowPurchaseForConfirmation.do", null, "deliverymethod="+req.getParameter("deliverymethod"));
//			}
//			if(req.getParameter("deliverymethod").equals("2")){
//				new HTTPGetRedirection(req, res, "PostDeliveryAddressDetail.do", null, "deliverymethod="+req.getParameter("deliverymethod"));
//			}
//			if(req.getParameter("deliverymethod").equals("3")){
//				new HTTPGetRedirection(req, res, "PostDeliveryAddressDetail.do", null, "deliverymethod="+req.getParameter("deliverymethod"));
//			}
//			
//		}
//		
		
	}
}