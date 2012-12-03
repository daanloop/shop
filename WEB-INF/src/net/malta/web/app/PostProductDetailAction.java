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


public class PostProductDetailAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		Product product = new ProductImpl();
		ProductForm productform = new ProductForm();
		Criteria criteria = session.createCriteria(Product.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			product = (Product) criteria.uniqueResult();
			new CopyProperties(product,productform);
		} else if(req.getAttribute("form")!=null){
                        productform = (ProductForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(productform.getId()));
			product = (Product) criteria.uniqueResult();
		}
		

		req.setAttribute("model",product);
		req.setAttribute("form",productform);


		Criteria criteriaCategory= session.createCriteria(Category.class);
		req.setAttribute("Categorys", criteriaCategory.list());

		Criteria criteriaCarriage= session.createCriteria(Carriage.class);
					req.setAttribute("Carriages", criteriaCarriage.list());

		 
		return mapping.findForward("success");
	}
}