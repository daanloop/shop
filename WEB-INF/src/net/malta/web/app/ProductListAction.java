package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.malta.model.Category;
import net.malta.model.Product;
import net.malta.web.utils.Pagination;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class ProductListAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{



		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Criteria criteria = session.createCriteria(Product.class);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("removed", new Boolean(false)));
		Pagination pagination=new Pagination();
        int pagesize = 6;
        int offset = 0;
        int currentpage = 1;
        
//        new Product().getName()
//        new Product().getThumnail()
//        new Product().getCategory()
        
        if(StringUtils.isNotBlank(req.getParameter("pagesize")) && req.getParameter("pagesize")!=null) {
        	//if(NumberUtils.isDigits(req.getParameter("pagesize")))
        		pagesize = Integer.parseInt(req.getParameter("pagesize"));
        }
        
//        if(StringUtils.isNotBlank(req.getParameter("offset")) && req.getParameter("offset")!=null) {
//        	if(NumberUtils.isDigits(req.getParameter("offset")))
//        		offset =  Integer.parseInt(req.getParameter("offset"));
//        }
        
        if(StringUtils.isNotBlank(req.getParameter("currentpage")) && req.getParameter("currentpage")!=null) {
        	if(NumberUtils.isDigits(req.getParameter("currentpage"))){
        		currentpage = Integer.parseInt(req.getParameter("currentpage"));
        		offset = ( currentpage -1 ) * pagesize;
        	}
        	
        }
        
        if(StringUtils.isNotBlank("category") && !req.getParameter("category").equals("")) {
        	Criteria criteriaCategory = session.createCriteria(Category.class);
        	criteriaCategory.add(Restrictions.idEq(Integer.parseInt(req.getParameter("category"))));
        	if(criteriaCategory.uniqueResult()!=null) {
        		criteria.add(Restrictions.eq("category", criteriaCategory.uniqueResult()));
        		//req.setAttribute("category", criteriaCategory.uniqueResult());
        	}
        }
        
		int max=pagination.getMax(criteria.list().size(), pagesize);
		req.setAttribute("max", max);

//		criteria.setMaxResults(pagesize);
		criteria.setFirstResult(offset);
		
		
		req.setAttribute("products",criteria.list());
		
		/*Criteria criteriaAward = session.createCriteria(Award.class);
		req.setAttribute("pages", 1 + ( (int ) ( criteriaAward.list().size() / pagesize ) ));*/
		



		return mapping.findForward("success");
/*
				
		<c:forEach var="page" begin="1" end="${pages}">
		<a href="ProductList.do?currentpage=${page}">
		${page}
		</a>
		</c:forEach>



*/
	}
	
	
}