package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.enclosing.util.HibernateSession;
import net.malta.model.DeliveryAddress;
import net.malta.model.PublicUser;
import net.malta.web.utils.DeliveryMethodUtils;
import net.malta.web.utils.Pagination;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DeliveryAddressListAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		PublicUser pu = (PublicUser)req.getSession().getAttribute("u");
		Criteria criteria = session.createCriteria(DeliveryAddress.class);
		
		// if(StringUtils.isNotBlank(req.getParameter("offset")) &&
		// req.getParameter("offset")!=null) {
		// if(NumberUtils.isDigits(req.getParameter("offset")))
		// offset = Integer.parseInt(req.getParameter("offset"));
		// }
		criteria.createCriteria("publicUser").add(Restrictions.eq("id", pu.getId()));

		DeliveryMethodUtils.setIntoSesssion(req);

		// Criteria criteriaAward = session.createCriteria(Award.class);
		// req.setAttribute("pages", 1 + ( (int ) ( criteriaAward.list().size()
		// / pagesize ) ));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(criteria.list()));
		return null;
	}


}