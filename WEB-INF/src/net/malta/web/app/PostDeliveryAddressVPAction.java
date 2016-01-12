package net.malta.web.app;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.DeliveryAddressForm;
import net.malta.model.*;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PostDeliveryAddressVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		DeliveryAddress deliveryAddress = new DeliveryAddressImpl();
		DeliveryAddressForm deliveryAddressform = (DeliveryAddressForm) form;

		String error = "";
		if(StringUtils.isBlank(deliveryAddressform.getName())){
		   error += "名前は空にはできません。<br />"; 
		}
		
		if(StringUtils.isBlank(deliveryAddressform.getKana())){
		   error += "カナは空にはできません。<br />"; 
		}
		
		//if(StringUtils.isBlank(deliveryAddressform.getZipthree())){
//		if(StringUtils.isBlank(req.getParameter("zipthree"))){		   
//			error += "郵便番号3桁は空にはできません。<br />"; 
//		}
//		
//		if(!StringUtils.isNumeric(req.getParameter("zipthree"))){
//		    error += "郵便番号3桁には数値のみを入れてください。<br />";
//		}
		//if(StringUtils.isBlank(deliveryAddressform.getZipfour())){
		
		//store 7 characters zipcode in zipfour field (forget zipthree field)
		if(StringUtils.isBlank(req.getParameter("zipfour"))){		
			error += "郵便番号は空にはできません。<br />"; 
		}
		
		if(!StringUtils.isNumeric(req.getParameter("zipfour"))){
		    error += "郵便番号には数値のみを入れてください。<br />";
		}
//		if(StringUtils.isBlank(req.getParameter("prefecture"))){
//		   error += "都道府県は空にはできません。<br />"; 
//		}
		
		if(StringUtils.isBlank(deliveryAddressform.getPhone())){
		   error += "電話番号は空にはできません。<br />"; 
		}
		
		if(!StringUtils.isNumeric(req.getParameter("phone"))){
		    error += "電話番号には数値のみを入れてください。<br />";
		}
		if(deliveryAddressform.getPrefecture().intValue() == 0){
			error += "都道府県を選択してください。<br />";
		}
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());

		
		if(StringUtils.isNotBlank(error)){
			req.getSession().setAttribute("error",error);
			req.setAttribute("form",deliveryAddressform);
			return mapping.findForward("error");
		}


//		Integer publicUserInt = deliveryAddressform.getPublicUser();
		deliveryAddressform.setPublicUser(null);
		Integer giftCardInt = deliveryAddressform.getGiftCard();
		deliveryAddressform.setGiftCard(null);
		Integer prefectureInt = deliveryAddressform.getPrefecture();
		deliveryAddressform.setPrefecture(null);
		
		if(deliveryAddressform.getId() == null || deliveryAddressform.getId().intValue() == 0){
			deliveryAddress.setId(null);
			deliveryAddressform.setId(null);
		}else{
			deliveryAddress.setId(deliveryAddressform.getId());
			Criteria criteria = session.createCriteria(DeliveryAddress.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			deliveryAddress = (DeliveryAddress) criteria.uniqueResult();

		}
		deliveryAddress.setName(deliveryAddressform.getName());
		deliveryAddress.setKana(deliveryAddressform.getKana());
		deliveryAddress.setZipthree(deliveryAddressform.getZipthree());
		deliveryAddress.setZipfour(deliveryAddressform.getZipfour());
		deliveryAddress.setPref(deliveryAddressform.getPref());
		deliveryAddress.setBuildingname(deliveryAddressform.getBuildingname());
		deliveryAddress.setPhone(deliveryAddressform.getPhone());
		deliveryAddress.setPreferreddate(deliveryAddressform.getPreferreddate());
		deliveryAddress.setPreferredtime(deliveryAddressform.getPreferredtime());
		deliveryAddress.setHasgiftcard(deliveryAddressform.isHasgiftcard());
		deliveryAddress.setAddress(deliveryAddressform.getAddress());
		deliveryAddress.setPref(deliveryAddressform.getPref());

		StringFullfiller.fullfil(deliveryAddress);
//		Criteria criteria2 = session.createCriteria(PublicUser.class);
//		criteria2.add(Restrictions.idEq(publicUserInt));
//		PublicUser publicuser = (PublicUser) criteria2.uniqueResult();
		deliveryAddress.setPublicUser((PublicUser)req.getSession().getAttribute("u"));
		Criteria criteria2 = session.createCriteria(GiftCard.class);
		criteria2.add(Restrictions.idEq(giftCardInt));
		GiftCard giftcard = (GiftCard) criteria2.uniqueResult();
		deliveryAddress.setGiftCard(giftcard);
		criteria2 = session.createCriteria(Prefecture.class);
		criteria2.add(Restrictions.idEq(prefectureInt));
		Prefecture prefecture = (Prefecture) criteria2.uniqueResult();
		deliveryAddress.setPrefecture(prefecture);
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(deliveryAddress);
		transaction.commit();
		session.flush();
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message","success");
			return mapping.findForward("success");
		}
		
		/**
		 *  if want (to post new address, after saving the current address at PostDeliveryAddress.jsp) 
		 *  then send back to PostDeliveryAddressDetail.do
		 */
		if(((Integer)req.getSession().getAttribute("deliverymethod")).intValue() == 2){
			new HTTPGetRedirection(req, res, "ShowPurchaseForConfirmation.html",null,"deliverymethod=" +  req.getParameter("deliverymethod") );
			return null;
		}
		
//		if(req.getParameter("sendType")!=null && !req.getParameter("sendType").equals("")) {
//			if(req.getParameter("sendType").equals("add")) {
//				new HTTPGetRedirection(req, res, "PostDeliveryAddressDetail.do", null);
//				return null;
//			}
//		}
		
		new HTTPGetRedirection(req, res, "DeliveryAddressList.html", null);
		return null;
	}
}