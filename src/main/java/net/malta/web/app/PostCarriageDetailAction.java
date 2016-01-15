package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.enclosing.util.HibernateSession;
import net.malta.beans.CarriageForm;
import net.malta.model.Carriage;
import net.malta.model.CarriageImpl;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class PostCarriageDetailAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		Carriage carriage = new CarriageImpl();
		CarriageForm carriageform = new CarriageForm();
		Criteria criteria = session.createCriteria(Carriage.class);
		criteria.add(Restrictions.eq("id", new Integer(1)));
		Carriage carriagea = (Carriage) criteria.uniqueResult();
		criteria = session.createCriteria(Carriage.class);
		criteria.add(Restrictions.eq("id", new Integer(2)));
		Carriage carriageb = (Carriage) criteria.uniqueResult();
		criteria = session.createCriteria(Carriage.class);
		criteria.add(Restrictions.eq("id", new Integer(3)));
		Carriage carriagec = (Carriage) criteria.uniqueResult();

//		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
//			criteria.add(Restrictions.idEq(Integer.valueOf(req
//					.getParameter("id"))));
//			carriage = (Carriage) criteria.uniqueResult();
//			new CopyProperties(carriage,carriageform);
//		} else if(req.getAttribute("form")!=null){
//                        carriageform = (CarriageForm)req.getAttribute("form");
//			criteria.add(Restrictions.idEq(carriageform.getId()));
//			carriage = (Carriage) criteria.uniqueResult();
//		}
//		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonElements = new JsonArray();

		JsonObject carriageaJson = new JsonObject();
		carriageaJson.addProperty("carriagea", gson.toJson(carriagea));
		jsonElements.add(carriageaJson);

		JsonObject carriagebJson = new JsonObject();
		carriagebJson.addProperty("carriageb", gson.toJson(carriageb));
		jsonElements.add(carriagebJson);

		JsonObject carriagecJson = new JsonObject();
		carriagecJson.addProperty("carriagec", gson.toJson(carriagec));
		jsonElements.add(carriagecJson);

		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(jsonElements));
		return null;
	}
	
	
}