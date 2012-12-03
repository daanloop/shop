package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.malta.beans.PublicUserForm;
import net.malta.model.GiftCard;
import net.malta.model.Prefecture;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.malta.model.Purchase;
import net.storyteller.desktop.CopyProperties;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PostPublicUserDetailAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		PublicUser publicUser = new PublicUserImpl();
		PublicUserForm publicUserform = new PublicUserForm();

		Purchase purchase = (Purchase) req.getSession()
				.getAttribute("purchase");

		String error = "";
		if (purchase.getChoises() == null || purchase.getChoises().size() == 0) {
			error += "商品がありません。<br />";
		}
		if (StringUtils.isNotBlank(error)) {
			req.getSession().setAttribute("error", error);
			// req.setAttribute("form",publicUser);
			// return mapping.findForward("error");
		}

		Criteria criteria = session.createCriteria(PublicUser.class);

		if (req.getAttribute("form") == null && req.getParameter("id") != null) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			publicUser = (PublicUser) criteria.uniqueResult();
			new CopyProperties(publicUser, publicUserform);
			if(publicUser.getPrefecture()!=null){
				publicUserform.setPrefecture(publicUser.getPrefecture().getId());
			}
			if(publicUser.getGiftCard()!=null){
				publicUserform.setGiftCard(publicUser.getGiftCard().getId());
				
			}
		} else if (req.getAttribute("form") != null) {
			publicUserform = (PublicUserForm) req.getAttribute("form");
			criteria.add(Restrictions.idEq(publicUserform.getId()));
			publicUser = (PublicUser) criteria.uniqueResult();
		} else if(req.getSession().getAttribute("u")!=null) {
			criteria.add(Restrictions.idEq(((PublicUser)req.getSession().getAttribute("u")).getId()));
			publicUser = (PublicUser) criteria.uniqueResult();
			new CopyProperties(publicUser, publicUserform);
			if(publicUser.getPrefecture()!=null){
				publicUserform.setPrefecture(publicUser.getPrefecture().getId());
			}
			if(publicUser.getGiftCard()!=null){
				publicUserform.setGiftCard(publicUser.getGiftCard().getId());
				
			}
		}
		Criteria criteriaGiftCard = session.createCriteria(GiftCard.class);
		req.setAttribute("GiftCards", criteriaGiftCard.list());
		Criteria criteriaprefecture = session.createCriteria(Prefecture.class);
		req.setAttribute("Prefectures", criteriaprefecture.list());
		req.setAttribute("model", publicUser);
		req.setAttribute("form", publicUserform);
		
		return mapping.findForward("success");
	}

}