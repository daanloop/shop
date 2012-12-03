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


                  Criteria criteriaPurchase= session.createCriteria(Purchase.class);
			req.setAttribute("Purchases", criteriaPurchase.list());

Criteria criteriaItem= session.createCriteria(Item.class);
			req.setAttribute("Items", criteriaItem.list());

 
		
		return mapping.findForward("success");
	}
	
	
}