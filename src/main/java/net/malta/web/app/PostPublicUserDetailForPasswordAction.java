package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.beans.PublicUserForm;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.storyteller.desktop.CopyProperties;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PostPublicUserDetailForPasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		PublicUser publicUser = new PublicUserImpl();
		PublicUserForm publicUserform = new PublicUserForm();
		Criteria criteria = session.createCriteria(PublicUser.class);

		if (req.getAttribute("form") == null && req.getParameter("id") != null) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			publicUser = (PublicUser) criteria.uniqueResult();
			new CopyProperties(publicUser, publicUserform);
		} else if (req.getAttribute("form") != null) {
			publicUserform = (PublicUserForm) req.getAttribute("form");
			criteria.add(Restrictions.idEq(publicUserform.getId()));
			publicUser = (PublicUser) criteria.uniqueResult();
		} else if (req.getParameter("hash") != null
				&& !req.getParameter("hash").equals("")) {
			criteria.add(Restrictions.eq("passwordonetimehash", req
					.getParameter("hash")));
			publicUser = (PublicUser) criteria.uniqueResult();
			if (publicUser == null) {
				req.getSession().setAttribute("error",
						"please enter a registered mail id");
				new HTTPGetRedirection(req, res,
						"ShowPublicUserForPassword.do", null);
				return null;
			} else {
				publicUser.setPasswordonetimehash("");
				Transaction transaction = session.beginTransaction();
				session.saveOrUpdate(publicUser);
				transaction.commit();
				session.flush();
			}
		}

		req.setAttribute("model", publicUser);
		req.setAttribute("form", publicUserform);

		return mapping.findForward("success");
	}
}