package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.malta.model.*;
import net.malta.model.crud.*;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.enclosing.util.HibernateSession;

public class ShowPurchaseForErrorAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		Purchase purchase = new PurchaseImpl();
		Criteria criteria = session.createCriteria(Purchase.class);

		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			purchase = (Purchase) criteria.uniqueResult();

		} else if (req.getAttribute("id") != null
				&& !req.getAttribute("id").equals("")) {
			criteria.add(Restrictions.idEq(req.getAttribute("id")));
			purchase = (Purchase) criteria.uniqueResult();
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonElements = new JsonArray();

		JsonObject purchaseJson = new JsonObject();
		purchaseJson.addProperty("purchase", gson.toJson(purchase));
		jsonElements.add(purchaseJson);

		JsonObject errorJson = new JsonObject();
		errorJson.addProperty("error", "エラー！！決済システム上でエラーが発生いたしました。購入手続きは完了していません。お手数ですが、もう一度始めからご購入ください。");
		jsonElements.add(errorJson);

		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(jsonElements));
		return null;
	}
	
	
}