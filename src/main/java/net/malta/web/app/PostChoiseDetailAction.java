package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.malta.model.*;
import net.malta.beans.*;


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
import net.storyteller.desktop.CopyProperties;


public class PostChoiseDetailAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Choise choise = new ChoiseImpl();
		ChoiseForm choiseform = new ChoiseForm();
		Criteria criteria = session.createCriteria(Choise.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			choise = (Choise) criteria.uniqueResult();
			new CopyProperties(choise,choiseform);
		} else if(req.getAttribute("form")!=null){
                        choiseform = (ChoiseForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(choiseform.getId()));
			choise = (Choise) criteria.uniqueResult();
		}

		req.setAttribute("model",choise);
		req.setAttribute("form",choiseform);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonElements = new JsonArray();

		Criteria criteriaPurchase= session.createCriteria(Purchase.class);
		JsonObject purchasesJson = new JsonObject();
		purchasesJson.addProperty("Purchases", gson.toJson(criteriaPurchase.list()));
		jsonElements.add(purchasesJson);

		Criteria criteriaItem= session.createCriteria(Item.class);
		JsonObject itemJson = new JsonObject();
		itemJson.addProperty("Items", gson.toJson(criteriaItem.list()));
		jsonElements.add(itemJson);

		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(jsonElements));
		return mapping.findForward("success");
	}
	
}