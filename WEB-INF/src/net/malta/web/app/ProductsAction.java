package net.malta.web.app;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.malta.beans.ProductForm;
import net.malta.model.Category;
import net.malta.model.Product;
import net.malta.model.ProductImpl;
import net.storyteller.desktop.CopyProperties;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProductsAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext(),35);

		Vector vector = new Vector();
		Criteria criteria = session.createCriteria(Product.class);

		if (StringUtils.isNotBlank(req.getParameter("category"))) {
			Criteria criteria2 = session.createCriteria(Category.class);
			criteria2.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("category"))));
			Category category = (Category) criteria2.uniqueResult();
			criteria.add(Restrictions.eq("category", category));
		}

		if (StringUtils.isNotBlank(req.getParameter("pub"))) {
			if (req.getParameter("pub").equals("true")) {
				criteria.add(Restrictions.eq("pub", true));
			} else {
				criteria.add(Restrictions.eq("pub", false));
			}
		}
		criteria.add(Restrictions.eq("removed", new Boolean(false)));
		criteria.addOrder(Order.desc("id"));
		req.setAttribute("products", criteria.list());

		// for (Iterator iter = criteria.list().iterator(); iter.hasNext();) {
		// Product product = (Product) iter.next();
		// vector.add(product);
		// }
		Product product = new ProductImpl();
		ProductForm productform = new ProductForm();
		criteria = session.createCriteria(Product.class);

//		if (req.getAttribute("form") == null && req.getParameter("id") != null) {
//			criteria.add(Restrictions.idEq(Integer.valueOf(req
//					.getParameter("id"))));
//			product = (Product) criteria.uniqueResult();
//			new CopyProperties(product, productform);
//		} else if (req.getAttribute("form") != null) {
//			productform = (ProductForm) req.getAttribute("form");
//			criteria.add(Restrictions.idEq(productform.getId()));
//			product = (Product) criteria.uniqueResult();
//		}
//		req.setAttribute("model", product);
//		req.setAttribute("form", productform);

		Criteria criteriaCategory = session.createCriteria(Category.class);
		req.setAttribute("Categorys", criteriaCategory.list());

		if (req.getParameter("displayexport") != null) {
			return mapping.findForward("displayexport");
		}

		return mapping.findForward("success");
	}

}