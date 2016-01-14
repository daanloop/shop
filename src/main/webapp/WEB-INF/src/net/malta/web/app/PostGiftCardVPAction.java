package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.StringFullfiller;
import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PostGiftCardVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		GiftCard giftCard = new GiftCardImpl();
		GiftCardForm giftCardform = (GiftCardForm) form;

                String error = "";


                
		
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		if(giftCardform.getId() == null || giftCardform.getId().intValue() == 0){
			giftCard.setId(null);
			giftCardform.setId(null);
		}else{
			giftCard.setId(giftCardform.getId());
			Criteria criteria = session.createCriteria(GiftCard.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			giftCard = (GiftCard) criteria.uniqueResult();

		}
                		giftCard.setName(giftCardform.getName());


		
		StringFullfiller.fullfil(giftCard);
                

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(giftCard);
		transaction.commit();
		session.flush();
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message","success");
			return mapping.findForward("success");
		}

		
		new HTTPGetRedirection(req, res, "PostGiftCardDetail.html", giftCard.getId().toString());
		return null;

		
	}
	
	
}