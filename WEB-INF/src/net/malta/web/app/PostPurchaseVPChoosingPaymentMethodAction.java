package net.malta.web.app;

import java.io.StringReader;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.PurchaseForm;
import net.malta.model.PaymentMethod;
import net.malta.model.Purchase;
import net.malta.model.StaticData;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PostPurchaseVPChoosingPaymentMethodAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {



		
		PurchaseForm purchaseform = (PurchaseForm) form;
		Integer paymentMethodInt = purchaseform.getPaymentMethod();
		purchaseform.setPaymentMethod(null);

        String error = "";
		if(paymentMethodInt==null || paymentMethodInt==0){
		   error += "支払い方法が選択されていません<br/>"; 
		}
		
		if(StringUtils.isNotBlank(error)){
			req.getSession().setAttribute("error",error);
			req.setAttribute("form",purchaseform);
			new HTTPGetRedirection(req, res, "ShowPurchaseForConfirmation.do", null);
			return null;
		}

		
		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		if(StringUtils.isNotBlank(req.getParameter("deliverymethod"))){
			Integer deliverymethodInteger = Integer.valueOf(req.getParameter("deliverymethod"));
			req.getSession().setAttribute("deliverymethod", deliverymethodInteger);
		}


		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		session.evict(purchase);
		
		session.refresh(purchase);

		StringFullfiller.fullfil(purchase);
		
		
		Criteria criteria2 = session.createCriteria(PaymentMethod.class);
		criteria2.add(Restrictions.idEq(paymentMethodInt));
		PaymentMethod paymentmethod = (PaymentMethod) criteria2.uniqueResult();
		purchase.setPaymentMethod(paymentmethod);
		



		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(purchase);
		transaction.commit();
		session.flush();
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message", "success");
			return mapping.findForward("success");
		}
		
		String st_code = "";
		if(paymentmethod.getId().intValue() == 1){
			st_code = "10000-0000-00000";
			System.err.println("st_code = 10000-0000-00000");
		}
		if(paymentmethod.getId().intValue() == 2){
			st_code = "00100-0000-00000";
			System.err.println("st_code = 00100-0000-00000");
		}
		if(paymentmethod.getId().intValue() == 3){
			st_code = "00010-0000-00000";
			System.err.println("st_code = 000010-0000-00000");

		}
		if(paymentmethod.getId().intValue() == 4){
			new HTTPGetRedirection(req, res, "PostPurchaseVPForSettingNonTemp.do",
					purchase.getId().toString(),"temp=0&deliverymethod="+req.getParameter("deliverymethod"));
			return null;
		}

		
		Criteria criteriaStaticData = session.createCriteria(StaticData.class);
		criteriaStaticData.add(Restrictions.eq("id", new Integer(1)));
		StaticData staticData = (StaticData) criteriaStaticData.uniqueResult();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhMMss");
		try {
			HttpClient httpClient = new HttpClient();
			PostMethod postMethod = new PostMethod(staticData.getCreditcardprocesurl());
			postMethod.addParameter(new NameValuePair("contract_code","23715700"));
			System.err.println("contract_code is " + 23715700);
//			postMethod.addParameter(new NameValuePair("contract_code","23278700"));　this is for akarui heya
			postMethod.addParameter(new NameValuePair("user_id",purchase.getPublicUser().getId().toString()));
			postMethod.addParameter(new NameValuePair("user_name", purchase.getPublicUser().getId().toString()));
			postMethod.addParameter(new NameValuePair("user_name_kana", new String(purchase.getPublicUser().getKana().getBytes("EUC-JP"))));
			postMethod.addParameter(new NameValuePair("user_mail_add",purchase.getPublicUser().getMail()));
			postMethod.addParameter(new NameValuePair("item_code",purchase.getId().toString()));
			postMethod.addParameter(new NameValuePair("item_name",purchase.getId().toString()));
			postMethod.addParameter(new NameValuePair("order_number","id" + purchase.getId().toString() + "date" +  dateFormat.format(new Date())));
			postMethod.addParameter(new NameValuePair("st_code",st_code));
			postMethod.addParameter(new NameValuePair("mission_code","1"));
			postMethod.addParameter(new NameValuePair("item_price",String.valueOf( purchase.getTotal()) ));
			postMethod.addParameter(new NameValuePair("process_code","1"));
			postMethod.addParameter(new NameValuePair("memo1","0"));
			postMethod.addParameter(new NameValuePair("memo2","0"));
			postMethod.addParameter(new NameValuePair("xml","1"));

			httpClient.executeMethod(postMethod);
			
			String response = postMethod.getResponseBodyAsString();
			System.err.println(response);
			
			SAXReader reader = new SAXReader();
			StringReader stringReader = new StringReader(response);
			Document document = reader.read(stringReader);
			Element rootElement = document.getRootElement();
			for (Iterator iterator = rootElement.elementIterator("result"); iterator.hasNext();) {
				Element element = (Element) iterator.next();
				if(element.attribute("redirect") !=null){
					String redirecturl = URLDecoder.decode(element.attributeValue("redirect"));		
					new HTTPGetRedirection(req, res, redirecturl);
					System.err.println("redirecting to epsilong");
					return null;
				}
				
			}
//			 <Epsilon_result>
//			  <result result="1" />
//			  <result redirect="http%3A%2F%2Fbeta.epsilon.jp%2Fcgi-bin%2Forder%2Fmethod_select3.cgi%3Ftrans_code%3DSsY6rqJcVec34" />
//			  </Epsilon_result>

			
			System.err.println(response);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		if (StringUtils.isNotBlank(req.getParameter("from"))
				&& !req.getParameter("from").equals("")) {
			System.err.println("mark 1");
			new HTTPGetRedirection(req, res, "PostPurchaseDetail.do", purchase
					.getId().toString(),"deliverymethod="+req.getParameter("deliverymethod"));
			return null;
		}

		System.err.println("mark 2, navigating to ForSettingNonTemp.");
		new HTTPGetRedirection(req, res, "PostPurchaseVPForSettingNonTemp.do",
				purchase.getId().toString(),"temp=0&deliverymethod="+req.getParameter("deliverymethod"));
		return null;
	}
}