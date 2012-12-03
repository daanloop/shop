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


public class PostPaymentMethodVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		PaymentMethod paymentMethod = new PaymentMethodImpl();
		PaymentMethodForm paymentMethodform = (PaymentMethodForm) form;

                String error = "";


                
		
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		if(paymentMethodform.getId() == null || paymentMethodform.getId().intValue() == 0){
			paymentMethod.setId(null);
			paymentMethodform.setId(null);
		}else{
			paymentMethod.setId(paymentMethodform.getId());
			Criteria criteria = session.createCriteria(PaymentMethod.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			paymentMethod = (PaymentMethod) criteria.uniqueResult();

		}
                		paymentMethod.setNote(paymentMethodform.getNote());
		paymentMethod.setName(paymentMethodform.getName());


		
		StringFullfiller.fullfil(paymentMethod);
                

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(paymentMethod);
		transaction.commit();
		session.flush();
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message","success");
			return mapping.findForward("success");
		}

		
		new HTTPGetRedirection(req, res, "PostPaymentMethodDetail.do", paymentMethod.getId().toString());
		return null;

		
	}
	
	
}