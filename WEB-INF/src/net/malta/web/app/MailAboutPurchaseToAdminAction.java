package net.malta.web.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.enclosing.util.SimpleMail;
import net.malta.model.Choise;
import net.malta.model.DeliveryAddressChoise;
import net.malta.model.Purchase;
import net.malta.model.StaticData;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MailAboutPurchaseToAdminAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			this.execute(Integer.valueOf(req.getParameter("id")),this.getServlet().getServletContext());

		}else{
			this.execute(null,this.getServlet().getServletContext());
		}

		return mapping.findForward("success");
	}
	public static void main(String[] args) {
		try {
				ApplicationContext context = new ClassPathXmlApplicationContext(
						new String[] { "applicationContext.xml",
								"applicationContext-localDataSource.xml" });
				MailAboutPurchaseToAdminAction action = new MailAboutPurchaseToAdminAction();
				action.execute(new Integer(1),context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void execute(Integer id,ServletContext context){
		BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(context);
		this.execute(id, factory);
		
	}

    public void execute(Integer id,BeanFactory factory){
		Session session = new HibernateSession().currentSession(factory);
		execute(id, session);
    	
    }
    public void execute(Integer id,Session session){
    	SimpleMail mail = SimpleMail.create(new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "applicationContext-localDataSource.xml", "applicationContext-mail.xml" }));
    	System.err.println("email sending to the admin---------------------------------------------");

    	Criteria criteria = session.createCriteria(Purchase.class);
    	criteria.add(Restrictions.eq("id", id));
    	Purchase purchase = (Purchase) criteria.uniqueResult();
    	Map model = new HashMap();
    	model.put("purchase", purchase);
    	model.put("dateFormatter", new SimpleDateFormat("yyyy/MM/dd"));
    	model.put("timeFormatter", new SimpleDateFormat("hh:mm"));

    	Criteria criteriastaticData = session.createCriteria(StaticData.class);
    	criteriastaticData.add(Restrictions.eq("id", new Integer(1)));
    	StaticData staticData = (StaticData) criteriastaticData.uniqueResult();


    	model.put("staticData", staticData);
		StringBuilder builder = new StringBuilder();

		model.put("deliveryaddress",builder.toString());
		
		
		
		for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
			Choise choise = (Choise) iterator.next();
//			if(choise.getDeliveryAddressChoises()){
				
//			}
			
		}
		Criteria criteriaDeliveryAddressChoise = session.createCriteria(DeliveryAddressChoise.class);
		criteriaDeliveryAddressChoise.createCriteria("choise").add(Restrictions.eq("purchase", purchase));
		if(criteriaDeliveryAddressChoise.list().size() > 0) {
			//when there are deliver address choises, then set 
			
			
			
		}else{
			builder.append("▼配送先情報");
			builder.append("================================================================");
			builder.append("【　お　　名　　前　】 " );
			builder.append(purchase.getPublicUser().getName() +  "様");
			builder.append("\r\n");
			builder.append("【　フ　リ　ガ　ナ】" );
			builder.append(purchase.getPublicUser().getKana());
			builder.append("\r\n");
			builder.append("【　郵　便　番　号　】"  );
			builder.append(purchase.getPublicUser().getZipfour());
			builder.append("\r\n");
			builder.append("【　ご　　住　　所　】" );
			builder.append(purchase.getPublicUser().getAddress());
			builder.append("\r\n");
			builder.append("【　電　話　番　号　】" );
			builder.append( purchase.getPublicUser().getPhone());
			builder.append("\r\n");
			builder.append("【Ｆ　Ａ　Ｘ　番　号】"  );
			builder.append(purchase.getPublicUser().getFax());
			builder.append("\r\n");
			builder.append("【　携　帯　番　号　】"  );
			builder.append(purchase.getPublicUser().getKeitai());
			builder.append("\r\n");
//			builder.append("【お届け希望　時間帯】" );
//			builder.append("\r\n");
//			builder.append("【　　備　　　考　　】");
//			builder.append("\r\n");
		}
		
		
		builder = new StringBuilder();
		for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
			Choise choise = (Choise) iterator.next();
			builder.append("----------------------------------------------------------------");
			builder.append("［　商　品　詳　細　］" );
			builder.append("\r\n");
			builder.append("【　商　品　番　号　】");
			builder.append(choise.getItem().getNo());
			builder.append("\r\n");
			builder.append("【　商　　品　　名　】");
			builder.append(choise.getItem().getName());
			builder.append("\r\n");
			builder.append("【　価　格　(税込)　】");
			builder.append(choise.getPricewithtax());
			builder.append("\r\n");
			builder.append("【　　数　　　量　　】");
			builder.append(choise.getOrdernum());
			builder.append("\r\n");
			builder.append("----------------------------------------------------------------");
			builder.append("\r\n");
			builder.append("\r\n");
		}
		
		model.put("purchasedetail", builder.toString());
		
		model.put("staticData", staticData);

    	try {
        	System.err.println("email sending to the admin---------------------------------------------");
    		mail.send("MailAboutPurchaseToAdmin.eml", "order@malta-net.jp", model);
        	System.err.println("email sent --------------------------------------------- + toukubo+admin@gmail.com");

    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}


    }
//    private void printDeliveryAddress(StringBuilder builder){
//		builder.append("▼配送先情報");
//		builder.append("================================================================");
//		builder.append("【　お　　名　　前　】 " + purchase.getPublicUser().getName() +  "様");
//		builder.append("【　フ　リ　ガ　ナ】"  + purchase.getPublicUser().getKana());
//		builder.append("【　郵　便　番　号　】"  + purchase.getPublicUser().getZipfour());
//		builder.append("【　ご　　住　　所　】" + purchase.getPublicUser().getAddress());
//		builder.append("【　電　話　番　号　】"  + purchase.getPublicUser().getPhone());
//		builder.append("【Ｆ　Ａ　Ｘ　番　号】"  + purchase.getPublicUser().getFax());
//		builder.append("【　携　帯　番　号　】"  + purchase.getPublicUser().getKeitai());
//		builder.append("【お届け希望　時間帯】" );
//		builder.append("【　　備　　　考　　】");
//
//    }
	
	
}
