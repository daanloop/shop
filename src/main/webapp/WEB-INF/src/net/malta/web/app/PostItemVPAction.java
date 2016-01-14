package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.StringFullfiller;
import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PostItemVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		if(req.getScheme().equals("http")) {
			res.sendRedirect("https://www.malta-net.jp/PostItemVP.do?item=" + req.getParameter("item"));
			System.err.println("it should be working.---------------------");
			return null;
		}else{
			System.err.println("not http. the scheme is " + req.getScheme());
		}

		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		Item item = new ItemImpl();
		ItemForm itemform = (ItemForm) form;

		String error = "";
		if(StringUtils.isBlank(itemform.getName())){
		   error += "名前は空にはできません。<br />"; 
		}
		
		if(StringUtils.isBlank(itemform.getNo())){
		   error += "商品Noは空にはできません。<br />"; 
		}else{
			if(itemform.getId() == null || itemform.getId().intValue() == 0){
				Criteria criteriaItem = session.createCriteria(Item.class);
				criteriaItem.add(Restrictions.eq("no", itemform.getNo()));
				Item repeatItem = (Item) criteriaItem.uniqueResult();
				if(repeatItem!=null) {
					error += "Noが重複しています。";
				}
			}
		}
		
		//if(StringUtils.isBlank(itemform.getPricewithtax())){
		if(StringUtils.isBlank(req.getParameter("pricewithtax"))){
		   error += "税込みは空にはできません。<br />"; 
		}
		
		if(!StringUtils.isNumeric(req.getParameter("pricewithtax"))){
		    error += "税込みには数値のみを入れてください。<br />";
		}
		
		if(StringUtils.isNotBlank(error)){
			req.getSession().setAttribute("error",error);
			req.setAttribute("form",itemform);
			return mapping.findForward("error");
		}


		Integer productInt = itemform.getProduct();
		itemform.setProduct(null);
		Integer carriageInt = itemform.getCarriage();
		itemform.setCarriage(null);

		
		if(itemform.getId() == null || itemform.getId().intValue() == 0){
			item.setId(null);
			itemform.setId(null);
		}else{
			item.setId(itemform.getId());
			Criteria criteria = session.createCriteria(Item.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			item = (Item) criteria.uniqueResult();

		}
		item.setName(itemform.getName());
		item.setStocknum(itemform.getStocknum());
		item.setNo(itemform.getNo());
		item.setPricewithtax(itemform.getPricewithtax());
		item.setSize(itemform.getSize());
		item.setMaterial(itemform.getMaterial());
		item.setCatchcopy(itemform.getCatchcopy());
		item.setDescription(itemform.getDescription());
		item.setNote(itemform.getNote());


		
		StringFullfiller.fullfil(item);
                		Criteria criteria2 = session.createCriteria(Product.class);
		criteria2.add(Restrictions.idEq(productInt));
		Product product = (Product) criteria2.uniqueResult();
		if(product!=null){
			item.setProduct(product);
		}
		criteria2 = session.createCriteria(Carriage.class);
		criteria2.add(Restrictions.idEq(carriageInt));
		Carriage carriage = (Carriage) criteria2.uniqueResult();
		item.setCarriage(carriage);


		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(item);
		transaction.commit();
		session.flush();
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message","success");
			return mapping.findForward("success");
		}

		if(StringUtils.isNotBlank(req.getParameter("from")) && "detail".equals(req.getParameter("from"))){		
			new HTTPGetRedirection(req, res, "PostItemDetail.html", item.getId().toString());
			return null;
		}
		
		new HTTPGetRedirection(req, res, "PostProductDetail.html", item.getProduct().getId().toString());
		return null;
	}
}