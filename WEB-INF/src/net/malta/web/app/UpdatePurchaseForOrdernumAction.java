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


public class UpdatePurchaseForOrdernumAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{


		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());


		Purchase purchase = new PurchaseImpl();
		PurchaseForm purchaseform = new PurchaseForm();
		Criteria criteria = session.createCriteria(Purchase.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			purchase = (Purchase) criteria.uniqueResult();
			new CopyProperties(purchase,purchaseform);
		} else if(req.getAttribute("form")!=null){
                        purchaseform = (PurchaseForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(purchaseform.getId()));
			purchase = (Purchase) criteria.uniqueResult();
		}
                   
                execute(purchase,session);


	}
	public static void main(String[] args) {
		try {
				ApplicationContext context = new ClassPathXmlApplicationContext(
						new String[] { "applicationContext.xml",
								"applicationContext-localDataSource.xml" });
				SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
				Session session = sessionFactory.openSession();
				UpdatePurchaseForOrdernumAction action = new UpdatePurchaseForOrdernumAction();
				Criteria criteria = session.createCriteria(Purchase.class);
				criteria.add(Restrictions.idEq(new Integer(1)));
				Purchase purchase = (Purchase) criteria.uniqueResult();
				action.execute(purchase, session);
				session.close();
				sessionFactory.close();
				sessionFactory =null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void execute(Purchase purchase,Session session){
		
	}

}