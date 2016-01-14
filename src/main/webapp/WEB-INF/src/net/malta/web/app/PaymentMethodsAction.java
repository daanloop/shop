package net.malta.web.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.malta.model.*;
import net.malta.beans.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import java.util.Date;

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


public class PaymentMethodsAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Vector vector = new Vector();
		Criteria criteria = session.createCriteria(PaymentMethod.class);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonElements = new JsonArray();

		JsonObject paymentMethodsJson = new JsonObject();
		paymentMethodsJson.addProperty("paymentMethods", gson.toJson(criteria.list()));
		jsonElements.add(paymentMethodsJson);

//		for (Iterator iter = criteria.list().iterator(); iter.hasNext();) {
//			PaymentMethod paymentMethod = (PaymentMethod) iter.next();
//			vector.add(paymentMethod);
//		}
		PaymentMethod paymentMethod = new PaymentMethodImpl();
		PaymentMethodForm paymentMethodform = new PaymentMethodForm();
		criteria = session.createCriteria(PaymentMethod.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			paymentMethod = (PaymentMethod) criteria.uniqueResult();
			new CopyProperties(paymentMethod,paymentMethodform);
		} else if(req.getAttribute("form")!=null){
                        paymentMethodform = (PaymentMethodForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(paymentMethodform.getId()));
			paymentMethod = (PaymentMethod) criteria.uniqueResult();
		}

		req.setAttribute("model",paymentMethod);
		req.setAttribute("form",paymentMethodform);

		if(req.getParameter("displayexport") !=null){
			return mapping.findForward("displayexport");
		}

		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(jsonElements));
		return mapping.findForward("success");
	}
	
	
}