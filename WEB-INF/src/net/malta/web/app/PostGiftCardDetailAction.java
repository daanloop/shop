package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


public class PostGiftCardDetailAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		GiftCard giftCard = new GiftCardImpl();
		GiftCardForm giftCardform = new GiftCardForm();
		Criteria criteria = session.createCriteria(GiftCard.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			giftCard = (GiftCard) criteria.uniqueResult();
			new CopyProperties(giftCard,giftCardform);
		} else if(req.getAttribute("form")!=null){
                        giftCardform = (GiftCardForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(giftCardform.getId()));
			giftCard = (GiftCard) criteria.uniqueResult();
		}
		

		req.setAttribute("model",giftCard);
		req.setAttribute("form",giftCardform);


                   
		
		return mapping.findForward("success");
	}
	
	
}