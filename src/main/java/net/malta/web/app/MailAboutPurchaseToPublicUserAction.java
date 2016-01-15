package net.malta.web.app;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.SimpleMail;
import net.malta.model.Choise;
import net.malta.model.DeliveryAddress;
import net.malta.model.DeliveryAddressChoise;
import net.malta.model.Purchase;
import net.malta.model.StaticData;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailAboutPurchaseToPublicUserAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
//		if (req.getParameter("id") != null
//				&& !req.getParameter("id").equals("")) {
//			this.execute(Integer.valueOf(req.getParameter("id")),
//					this.getServlet().getServletContext(),Integer.parseInt((String)req.getSession().getAttribute("deliveryaddress")));
//		}else{
//			this.execute(null,this.getServlet().getServletContext());
//		}
		return mapping.findForward("success");
	}

    public void execute(Integer id,Session session,int deliverymethod){
		SimpleMail mail = SimpleMail.create(new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "applicationContext-localDataSource.xml", "applicationContext-mail.xml" }));

		Criteria criteria = session.createCriteria(Purchase.class);
		criteria.add(Restrictions.eq("id", id));
		Purchase purchase = (Purchase) criteria.uniqueResult();
	        	Map model = new HashMap();
		model.put("purchase", purchase);
		Locale l = new Locale("ja", "JP");
		model.put("dateFormatter", new SimpleDateFormat("yyyy/MM/dd"));
		model.put("dayFormatter", new SimpleDateFormat("E", l));		
		model.put("timeFormatter", new SimpleDateFormat("HH:mm"));

		Criteria criteriastaticData = session.createCriteria(StaticData.class);
		criteriastaticData.add(Restrictions.eq("id", new Integer(1)));
		StaticData staticData = (StaticData) criteriastaticData.uniqueResult();

		
		StringBuilder builder = new StringBuilder();
		Criteria criteriaDeliveryAddressChoise = session.createCriteria(DeliveryAddressChoise.class);
		criteriaDeliveryAddressChoise.createCriteria("choise").add(Restrictions.eq("purchase", purchase));
				//when there are no delivery address ( direct to public User)
				builder.append("â–¼é…�é€�å…ˆæƒ…å ±");
				builder.append("\r\n");
				builder.append("================================================================");
				builder.append("\r\n");
				builder.append("ã�Šå��å‰�ã€€ã€€ã€€ã€€ã€€ã€€ï¼š" );
				System.out.println("purchase object "+purchase);
				System.out.println("publicuser "+purchase.getPublicUser());
				builder.append(purchase.getPublicUser().getName() +  "æ§˜");
				builder.append("\r\n");
				builder.append("ãƒ•ãƒªã‚¬ãƒŠã€€ã€€ã€€ã€€ã€€ï¼š" );
				builder.append(purchase.getPublicUser().getKana());
				builder.append("\r\n");
				builder.append("éƒµä¾¿ç•ªå�·ã€€ã€€ã€€ã€€ã€€ï¼š"  );
				builder.append(purchase.getPublicUser().getZipfour());
				builder.append("\r\n");
				builder.append("ã�”ä½�æ‰€ã€€ã€€ã€€ã€€ã€€ã€€ï¼š" );
				if(purchase.getPublicUser().getPrefecture()!=null){
					builder.append(purchase.getPublicUser().getPrefecture().getName() + " " + purchase.getPublicUser().getAddress() + " " + purchase.getPublicUser().getBuildingname());
				}
				builder.append("\r\n");
				builder.append("é›»è©±ç•ªå�·ã€€ã€€ã€€ã€€ã€€ï¼š" );
				builder.append( purchase.getPublicUser().getPhone());
				builder.append("\r\n");
			builder.append("\r\n");
			for (Iterator iterator = purchase.getChoises().iterator(); iterator.hasNext();) {
				Choise choise = (Choise) iterator.next();
				builder.append("----------------------------------------------------------------");
				builder.append("\r\n");
				builder.append("å•†å“�è©³ç´°" );
				builder.append("\r\n");
				builder.append("----------------------------------------------------------------");
				builder.append("\r\n");
				builder.append("å•†å“�å��ã€€ã€€ã€€ã€€ã€€ã€€ï¼š");
				builder.append(choise.getName());
				builder.append("\r\n");
				builder.append("ä¾¡æ ¼ï¼ˆç¨Žè¾¼ï¼‰ã€€ã€€ã€€ï¼š");
				builder.append(choise.getPricewithtax()+"å††");
				builder.append("\r\n");
				builder.append("æ•°é‡�ã€€ã€€ã€€ã€€ã€€ã€€ã€€ï¼š");
				builder.append(choise.getOrdernum());
				builder.append("\r\n");
				builder.append("----------------------------------------------------------------");
				builder.append("\r\n");
				builder.append("\r\n");
			}
			model.put("deliveryaddress",builder.toString().replaceAll("ï½ž", " - "));
//
		try {
			model.put("fromstring", MimeUtility.encodeText("AFRICA & LEO", "ISO-2022-JP", "B") + "<"+staticData.getFromaddress()+">");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		model.put("staticData", staticData);

		try {
	    	System.err.println("email sending to the admin---------------------------------------------");
			mail.send("MailAboutPurchaseToPublicUser.eml", purchase.getPublicUser().getMail(), model);
			mail.send("MailAboutPurchaseToAdmin.eml", "aandl.order@gmail.com", model);
			mail.send("MailAboutPurchaseToAdmin.eml", "toukubo+africaandleo@gmail.com", model);
	    	System.err.println("email sent to the --------------------------------------------- " + purchase.getPublicUser().getMail());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        }
	
	
}
