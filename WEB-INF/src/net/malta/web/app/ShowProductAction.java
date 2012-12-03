package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.malta.model.Product;
import net.malta.model.ProductImpl;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ShowProductAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		Product product = new ProductImpl();
		Criteria criteria = session.createCriteria(Product.class);

		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			product = (Product) criteria.uniqueResult();

		} else if (req.getAttribute("id") != null
				&& !req.getAttribute("id").equals("")) {
			criteria.add(Restrictions.idEq(req.getAttribute("id")));
			product = (Product) criteria.uniqueResult();
		}

		req.setAttribute("product",product);
		
		
		Criteria criteriaProduct = session.createCriteria(Product.class);
		criteriaProduct.add(Restrictions.eq("removed", new Boolean(false)));
		criteriaProduct.add(Restrictions.eq("category", product.getCategory()));
		criteriaProduct.addOrder(Order.desc("id"));
		if(criteriaProduct.list().size()>1) {
			if(criteriaProduct.list().indexOf(product)==0) {
				req.setAttribute("next", criteriaProduct.list().get(criteriaProduct.list().indexOf(product)+1));

			}else if(criteriaProduct.list().size()-1==criteriaProduct.list().indexOf(product)) {
				req.setAttribute("prev", criteriaProduct.list().get(criteriaProduct.list().indexOf(product)-1));
			}else{
				req.setAttribute("prev", criteriaProduct.list().get(criteriaProduct.list().indexOf(product)-1));
				req.setAttribute("next", criteriaProduct.list().get(criteriaProduct.list().indexOf(product)+1));
			}
		}

		req.setAttribute("Products", criteriaProduct.list());
		
		return mapping.findForward("success");
	}
	
	
}