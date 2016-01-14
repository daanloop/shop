package net.malta.web.app;

import net.enclosing.util.HibernateSession;
import net.malta.beans.PurchaseForm;
import net.malta.model.Purchase;
import net.malta.model.PurchaseImpl;
import net.storyteller.desktop.CopyProperties;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

	return new ActionForward();
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