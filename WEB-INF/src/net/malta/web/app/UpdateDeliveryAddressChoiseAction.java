package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;
import net.storyteller.desktop.CopyProperties;

import java.io.File;
import java.util.Iterator;

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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UpdateDeliveryAddressChoiseAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		/**
		 * 
		 * loop on purchase.choises
		 * for each choise.id.toString() parameter
		 * do set deliveryAddressChoise.(deliveryAddress)
		 *    set deliveryAddressChoise.(choise)
		 *    set deliveryAddressChoise.ordernum(paramValue)
 		 * 
		 */
		
		if(req.getParameter("deliveryAddress")==null || req.getParameter("deliveryAddress").equals("")) {
			new HTTPGetRedirection(req, res, "DeliveryAddressChoiseList.do",null);
			return null;
		}
		
		DeliveryAddressChoise deliveryAddressChoise = new DeliveryAddressChoiseImpl();
		DeliveryAddressChoiseForm deliveryAddressChoiseform = new DeliveryAddressChoiseForm();
		Criteria criteria = session.createCriteria(DeliveryAddressChoise.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			deliveryAddressChoise = (DeliveryAddressChoise) criteria.uniqueResult();
			new CopyProperties(deliveryAddressChoise,deliveryAddressChoiseform);
		} else if(req.getAttribute("form")!=null){
                        deliveryAddressChoiseform = (DeliveryAddressChoiseForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(deliveryAddressChoiseform.getId()));
			deliveryAddressChoise = (DeliveryAddressChoise) criteria.uniqueResult();
		}
                   
		Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
		DeliveryAddress deliveryAddress = new DeliveryAddressImpl();
		
		Criteria criteriaDeliveryAddress = session.createCriteria(DeliveryAddress.class);
		criteriaDeliveryAddress.add(Restrictions.idEq(Integer.parseInt(req.getParameter("deliveryAddress"))));
		deliveryAddress = (DeliveryAddress) criteriaDeliveryAddress.uniqueResult();
		
		for (Iterator iter = purchase.getChoises().iterator(); iter.hasNext();) {
			Choise c = (Choise) iter.next();
			if(req.getParameter("reset")!=null && !req.getParameter("reset").equals("")) {
				deliveryAddressChoise = new DeliveryAddressChoiseImpl();
				criteria = session.createCriteria(DeliveryAddressChoise.class);
				criteria.add(Restrictions.eq("deliveryAddress", deliveryAddress));
				criteria.add(Restrictions.eq("choise", c));
				if(criteria.uniqueResult()!=null) {
					deliveryAddressChoise = (DeliveryAddressChoise)criteria.uniqueResult();
					deliveryAddressChoise.setOrdernum(0);
					executeDelete(deliveryAddressChoise,session);
					//TODO: need to create class and method new DeleteDeliveryAddressChoise.execute(deliveryAddressChoise,session); 
				}
			}else{
				String paramValue = req.getParameter(c.getId().toString());
				if(paramValue!=null && !paramValue.equals("")) {
					Integer paramValueInt = Integer.parseInt(paramValue);
					if(paramValueInt!=0) {
						deliveryAddressChoise = new DeliveryAddressChoiseImpl();
						criteria = session.createCriteria(DeliveryAddressChoise.class);
						criteria.add(Restrictions.eq("deliveryAddress", deliveryAddress));
						criteria.add(Restrictions.eq("choise", c));
						if(criteria.uniqueResult()!=null) {
							deliveryAddressChoise = (DeliveryAddressChoise)criteria.uniqueResult();
							paramValueInt += deliveryAddressChoise.getOrdernum();
						}else{
							deliveryAddressChoise.setDeliveryAddress(deliveryAddress);
							deliveryAddressChoise.setChoise(c);
						}
						deliveryAddressChoise.setOrdernum(paramValueInt);
						execute(deliveryAddressChoise,session);			
					}
				}
			}
		}

		new HTTPGetRedirection(req, res, "DeliveryAddressChoiseList.do",null);
		return null;
	}
	
	public static void main(String[] args) {
		try {
				ApplicationContext context = new ClassPathXmlApplicationContext(
						new String[] { "applicationContext.xml",
								"applicationContext-localDataSource.xml" });
				SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
				Session session = sessionFactory.openSession();
				UpdateDeliveryAddressChoiseAction action = new UpdateDeliveryAddressChoiseAction();
				Criteria criteria = session.createCriteria(DeliveryAddressChoise.class);
				criteria.add(Restrictions.idEq(new Integer(1)));
				DeliveryAddressChoise deliveryAddressChoise = (DeliveryAddressChoise) criteria.uniqueResult();
				action.execute(deliveryAddressChoise, session);
				session.close();
				sessionFactory.close();
				sessionFactory =null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void execute(DeliveryAddressChoise deliveryAddressChoise,Session session){
		StringFullfiller.fullfil(deliveryAddressChoise);
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(deliveryAddressChoise);
		transaction.commit();
		session.flush();
	}
	
	public void executeDelete(DeliveryAddressChoise deliveryAddressChoise,Session session){
		StringFullfiller.fullfil(deliveryAddressChoise);
		Transaction transaction = session.beginTransaction();
		session.delete(deliveryAddressChoise);
		transaction.commit();
		session.flush();
	}

}