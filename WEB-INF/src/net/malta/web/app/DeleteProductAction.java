
package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.model.Product;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DeleteProductAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{



		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));

		Product product = (Product) criteria.uniqueResult();
		
		product.setRemoved(true);
//		session.delete(product);
		session.save(product);
		transaction.commit();
		session.flush();
		
		new HTTPGetRedirection(req, res, "Products.html",null);
		return null;
	}
}