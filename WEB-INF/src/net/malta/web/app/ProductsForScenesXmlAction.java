package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import java.util.Date;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;


import net.enclosing.util.HibernateSession;
import net.storyteller.desktop.CopyProperties;


public class ProductsForScenesXmlAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{



		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext(),60);

                Vector vector = new Vector();
		Criteria criteria = session.createCriteria(Product.class);
        criteria.addOrder(Order.desc("id"));

if(StringUtils.isNotBlank(req.getParameter("removed"))){   if(req.getParameter("removed").equals("true")){
      criteria.add(Restrictions.eq("removed",true));
   }else{
      criteria.add(Restrictions.eq("removed",false));
   }
}


		if(StringUtils.isNotBlank(req.getParameter("category"))) {
			Criteria criteria2 = session.createCriteria(Category.class);
			criteria2.add(Restrictions.idEq(Integer.valueOf(req.getParameter("category"))));
			Category category = (Category) criteria2.uniqueResult();
			criteria.add(Restrictions.eq("category", category));
		}
 



	      criteria.add(Restrictions.eq("pub",true));
//
//
//if(StringUtils.isNotBlank(req.getParameter("pub"))){   if(req.getParameter("pub").equals("true")){
//      criteria.add(Restrictions.eq("pub",true));
//   }else{
//      criteria.add(Restrictions.eq("pub",false));
//   }
//}






		if(StringUtils.isNotBlank(req.getParameter("datestartdate")) && StringUtils.isNotBlank(req.getParameter("dateenddate"))){
			Date  startDate = (new SimpleDateFormat("yyyy/MM/dd")).parse(req.getParameter("datestartdate"));
			Date endDate = (new SimpleDateFormat("yyyy/MM/dd")).parse(req.getParameter("dateenddate"));
			criteria.add(Restrictions.between("date", startDate, endDate));
		}



		req.setAttribute("products",criteria.list());


//		for (Iterator iter = criteria.list().iterator(); iter.hasNext();) {
//			Product product = (Product) iter.next();
//			vector.add(product);
//		}
		Product product = new ProductImpl();
		ProductForm productform = new ProductForm();
		criteria = session.createCriteria(Product.class);


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

 

		

                if(req.getParameter("displayexport") !=null){
     		    return mapping.findForward("displayexport");
                }

		return mapping.findForward("success");
	}
	
	
}