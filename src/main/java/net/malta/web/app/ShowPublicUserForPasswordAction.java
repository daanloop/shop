package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.enclosing.util.HibernateSession;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ShowPublicUserForPasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		PublicUser publicUser = new PublicUserImpl();
		Criteria criteria = session.createCriteria(PublicUser.class);

		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			publicUser = (PublicUser) criteria.uniqueResult();

		} else if (req.getAttribute("id") != null
				&& !req.getAttribute("id").equals("")) {
			criteria.add(Restrictions.idEq(req.getAttribute("id")));
			publicUser = (PublicUser) criteria.uniqueResult();
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(publicUser));
		return null;
	}
}