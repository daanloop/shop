package net.malta.web.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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


public class ProductsForScenesXm2Action extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext(),60);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonElements = new JsonArray();

		Vector vector = new Vector();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.addOrder(Order.desc("id"));

		if (StringUtils.isNotBlank(req.getParameter("removed"))) {
			if (req.getParameter("removed").equals("true")) {
				criteria.add(Restrictions.eq("removed", true));
			} else {
				criteria.add(Restrictions.eq("removed", false));
			}
		}

		if (StringUtils.isNotBlank(req.getParameter("category"))) {
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

		JsonObject products = new JsonObject();
		products.addProperty("products", gson.toJson(criteria.list()));
		jsonElements.add(products);

//		for (Iterator iter = criteria.list().iterator(); iter.hasNext();) {
//			Product product = (Product) iter.next();
//			vector.add(product);
//		}
		Item item = new ItemImpl();
		ItemForm itemform = new ItemForm();
		criteria = session.createCriteria(Item.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			item = (Item) criteria.uniqueResult();
			new CopyProperties(item,itemform);
		} else if(req.getAttribute("form")!=null){
			itemform = (ItemForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(itemform.getId()));
			item = (Item) criteria.uniqueResult();
		}

		JsonObject mainItem = new JsonObject();
		mainItem.addProperty("mainitem", gson.toJson(item));
		mainItem.addProperty("form", gson.toJson(itemform));
		jsonElements.add(mainItem);

		Criteria criteriaCategory= session.createCriteria(Category.class);
		JsonObject categories = new JsonObject();
		categories.addProperty("Categories", gson.toJson(criteriaCategory.list()));
		jsonElements.add(categories);

		if(req.getParameter("displayexport") != null){
			return mapping.findForward("displayexport");
		}

		res.setContentType("application/json");
		res.getWriter().print(gson.toJson(jsonElements));
		return null;
	}


}