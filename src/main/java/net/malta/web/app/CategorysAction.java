package net.malta.web.app;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.enclosing.util.HibernateSession;
import net.malta.beans.CategoryForm;
import net.malta.model.Category;
import net.malta.model.CategoryImpl;
import net.storyteller.desktop.CopyProperties;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CategorysAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Vector vector = new Vector();
		Criteria criteria = session.createCriteria(Category.class);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonElements = new JsonArray();

		JsonObject categoriesJson = new JsonObject();
		categoriesJson.addProperty("categories", gson.toJson(criteria.list()));
		jsonElements.add(categoriesJson);

		// for (Iterator iter = criteria.list().iterator(); iter.hasNext();) {
		// Category category = (Category) iter.next();
		// vector.add(category);
		// }
		Category category = new CategoryImpl();
		CategoryForm categoryform = new CategoryForm();
		criteria = session.createCriteria(Category.class);

		if (req.getAttribute("form") == null && req.getParameter("id") != null) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			category = (Category) criteria.uniqueResult();
			new CopyProperties(category, categoryform);
		} else if (req.getAttribute("form") != null) {
			categoryform = (CategoryForm) req.getAttribute("form");
			criteria.add(Restrictions.idEq(categoryform.getId()));
			category = (Category) criteria.uniqueResult();
		}

		req.setAttribute("model", category);
		req.setAttribute("form", categoryform);

		if (req.getParameter("displayexport") != null) {
			return mapping.findForward("displayexport");
		}

		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(jsonElements));
		return mapping.findForward("success");
	}
}