package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.malta.model.DeliveryAddress;
import net.malta.model.DeliveryAddressChoise;
import net.malta.model.PublicUser;
import net.malta.model.Purchase;
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

public class DeliveryAddressChoiseListAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest req, HttpServletResponse res) throws Exception {

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext(),10);
		PublicUser publicUser = (PublicUser)req.getSession().getAttribute("u");
		Criteria criteria = session.createCriteria(DeliveryAddressChoise.class);
		Pagination pagination = new Pagination();
		int pagesize = 6;
		int offset = 0;
		int currentpage = 1;

		if (StringUtils.isNotBlank(req.getParameter("pagesize"))
				&& req.getParameter("pagesize") != null) {
			// if(NumberUtils.isDigits(req.getParameter("pagesize")))
			pagesize = Integer.parseInt(req.getParameter("pagesize"));
		}

		// if(StringUtils.isNotBlank(req.getParameter("offset")) &&
		// req.getParameter("offset")!=null) {
		// if(NumberUtils.isDigits(req.getParameter("offset")))
		// offset = Integer.parseInt(req.getParameter("offset"));
		// }

		if (StringUtils.isNotBlank(req.getParameter("currentpage"))
				&& req.getParameter("currentpage") != null) {
			if (NumberUtils.isDigits(req.getParameter("currentpage"))) {
				currentpage = Integer.parseInt(req.getParameter("currentpage"));
				offset = (currentpage - 1) * pagesize;
			}

		}

		int max = pagination.getMax(criteria.list().size(), pagesize);
		req.setAttribute("max", max);

		criteria.setMaxResults(pagesize);
		criteria.setFirstResult(offset);

		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		if(purchase.getChoises().size()!=0) {
			criteria.add(Restrictions.in("choise", purchase.getChoises()));
		}
		req.setAttribute("deliveryAddressChoises", criteria.list());

		Criteria criteriaDeliveryAddressChoise = session
				.createCriteria(DeliveryAddressChoise.class);
		req.setAttribute("pages", 1 + ((int) (criteriaDeliveryAddressChoise
				.list().size() / pagesize)));
		
		Criteria criteriaDeliveryAddress = session.createCriteria(DeliveryAddress.class);
		criteriaDeliveryAddress.add(Restrictions.eq("publicUser", publicUser));
		req.setAttribute("DeliveryAddresss", criteriaDeliveryAddress.list());
		
//		new DeliveryAddress().getDeliveryAddressChoises();
//		new DeliveryAddressChoise().getChoise().getItem().getName();
//		new DeliveryAddressChoise().getOrdernum();
		
		return mapping.findForward("success");
		/*
		 * 
		 * <c:forEach var="page" begin="1" end="${pages}"> <a
		 * href="DeliveryAddressChoiseList.do?currentpage=${page}"> ${page} </a>
		 * </c:forEach>
		 * 
		 * 
		 * 
		 */
	}

}