package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.PublicUserForm;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.malta.model.Purchase;
import net.malta.web.utils.SessionData;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PostPublicUserVPForPasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		
		PublicUser publicUser = new PublicUserImpl();
		PublicUserForm publicUserform = (PublicUserForm) form;
//		PublicUser publicUser2 = (PublicUser)req.getSession().getAttribute("u");
//		if(publicUser2.isTemp()) {
//			req.getSession().setAttribute("authenticationerr","please login <br />");
//			new HTTPGetRedirection(req, res, "PostPublicUserDetail.do",null);
//			return null;
//		}

		String error = "";
		if (StringUtils.isBlank(publicUserform.getPassword())) {
			error += "パスワードは空にはできません。<br />";
		}

		if (!publicUserform.getPassword().matches("[a-zA-Z0-9&/-]*")) {
			error += "パスワードは半角英数字及び記号(/&-)のみです。";
		}

		if (StringUtils.isNotBlank(error)) {
			req.getSession().setAttribute("error", error);
			req.setAttribute("form", publicUserform);
			return mapping.findForward("error");
		}

		Criteria criteriaPublicUser = session.createCriteria(PublicUser.class);
		criteriaPublicUser.add(Restrictions.idEq(publicUserform.getId()));
		publicUser=(PublicUser) criteriaPublicUser.uniqueResult();
		
		publicUser.setPassword(publicUserform.getPassword());

		StringFullfiller.fullfil(publicUser);

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(publicUser);
		transaction.commit();
		session.flush();
		SessionData.update(publicUser,(Purchase)req.getSession().getAttribute("purchase"),req,res,session);
		req.getSession().setAttribute("msg", "パスワードは正しく変更されました。 <br />");
		new HTTPGetRedirection(req, res, "PostPublicUserDetailForPassword.html", publicUser
				.getId().toString());
		return null;
	}
}