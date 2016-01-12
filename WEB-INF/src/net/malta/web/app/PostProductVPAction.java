package net.malta.web.app;

import net.malta.model.*;
import net.malta.web.utils.MainItem;
import net.malta.beans.*;

import java.io.File;
import java.util.Date;

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


public class PostProductVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Product product = new ProductImpl();
		ProductForm productform = (ProductForm) form;

                String error = "";
//		if(!productform.isDateIsValid()){
//		   error += "日付 はyyyy/MM/ddにしてください。<br />";
//		}
//		if(!StringUtils.isBlank(productform.getSize()) && !StringUtils.isNumeric(req.getParameter("size"))){
//		    error += "サイズには数値のみを入れてください。<br />";
//		}
		if(StringUtils.isBlank(productform.getNo())){
		   error += "商品Noは空にはできません。<br />"; 
		}
		
		if(StringUtils.isBlank(productform.getName())){
		   error += "名前は空にはできません。<br />"; 
		}
		
		//if(StringUtils.isBlank(productform.getPricewithtax())){
		if(StringUtils.isBlank(req.getParameter("pricewithtax"))){
		   error += "価格は空にはできません。<br />"; 
		}
		
		if(!StringUtils.isBlank(productform.getSize()) && !StringUtils.isNumeric(req.getParameter("pricewithtax"))){
		    error += "税込みには数値のみを入れてください。<br />";
		}
		if(!StringUtils.isBlank(productform.getSize()) &&!StringUtils.isNumeric(req.getParameter("stocknum"))){
		    error += "在庫数には数値のみを入れてください。<br />";
		}
		if(StringUtils.isNotBlank(error)){
			req.getSession().setAttribute("error",error);
			req.setAttribute("form",productform);
			return mapping.findForward("error");
		}


		Integer categoryInt = productform.getCategory();
		productform.setCategory(null);
		Integer carriageInt = Integer.valueOf(req.getParameter("carriage"));

		
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		if(productform.getId() == null || productform.getId().intValue() == 0){
			product.setId(null);
			productform.setId(null);
		}else{
			product.setId(productform.getId());
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.idEq(Integer.valueOf(req.getParameter("id"))));
			product = (Product) criteria.uniqueResult();

		}
		product.setDate(new Date());
		product.setSize(productform.getSize());
		
		Item item = null;
		if(MainItem.Of((Object)product, session) !=null){
			item = MainItem.Of((Object)product,session);
		}else{
			item = new ItemImpl();
		}
		item.setNo(productform.getNo());
		product.setName(productform.getName());
		
		item.setName(productform.getMainitemname());
		item.setPricewithtax(productform.getPricewithtax());
		item.setCatchcopy(productform.getCatchcopy());
		item.setMaterial(productform.getMaterial());
		item.setDescription(productform.getDescription());
		item.setNote(productform.getNote());
		item.setStocknum(productform.getStocknum());
		item.setSize(productform.getSize());
		item.setMain(true);
		product.setPub(productform.isPub());


		
		StringFullfiller.fullfil(product);
                		Criteria criteria2 = session.createCriteria(Category.class);
		criteria2.add(Restrictions.idEq(categoryInt));
		Category category = (Category) criteria2.uniqueResult();
		product.setCategory(category);

		criteria2 = session.createCriteria(Carriage.class);
		criteria2.add(Restrictions.idEq(carriageInt));
		Carriage carriage = (Carriage) criteria2.uniqueResult();
		item.setCarriage(carriage);

		StringFullfiller.fullfil(item);
		item.setProduct(product);
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(product);
		session.saveOrUpdate(item);
		transaction.commit();
		session.flush();
		if (StringUtils.isNotBlank(req.getParameter("ajax"))) {
			req.setAttribute("message","success");
			return mapping.findForward("success");
		}
		
		if(StringUtils.isNotBlank(req.getParameter("from")) && "detail".equals(req.getParameter("from"))){
			new HTTPGetRedirection(req, res, "PostProductDetail.html", product.getId().toString());
			return null;
		}

		new HTTPGetRedirection(req, res, "Products.html", null);
		return null;
	}
	
	
}