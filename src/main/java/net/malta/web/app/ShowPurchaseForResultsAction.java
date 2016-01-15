package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.model.Purchase;
import net.malta.model.PurchaseImpl;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ShowPurchaseForResultsAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		Purchase purchase = new PurchaseImpl();
		Criteria criteria = session.createCriteria(Purchase.class);
		
		if(req.getParameter("result")==null){
			new HTTPGetRedirection(req, res, "ShowPurchaseForThanks.html?paymentMethod=2", null);
			return null;
		}else if(req.getParameter("result").equals("1")){
			new HTTPGetRedirection(req, res, "ShowPurchaseForThanks.html", null);
			return null;
		}
		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			purchase = (Purchase) criteria.uniqueResult();

		} else if (req.getAttribute("id") != null
				&& !req.getAttribute("id").equals("")) {
			criteria.add(Restrictions.idEq(req.getAttribute("id")));
			purchase = (Purchase) criteria.uniqueResult();
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(purchase));
		return null;
	}
	
	
}