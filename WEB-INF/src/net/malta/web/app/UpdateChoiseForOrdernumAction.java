package net.malta.web.app;

import net.malta.model.*;
import net.malta.beans.*;
import net.storyteller.desktop.CopyProperties;

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
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UpdateChoiseForOrdernumAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{


		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());

		Choise choise = new ChoiseImpl();
		ChoiseForm choiseform = new ChoiseForm();
		Criteria criteria = session.createCriteria(Choise.class);

		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			choise = (Choise) criteria.uniqueResult();
			new CopyProperties(choise,choiseform);
		} else if(req.getAttribute("form")!=null){
                        choiseform = (ChoiseForm)req.getAttribute("form");
			criteria.add(Restrictions.idEq(choiseform.getId()));
			choise = (Choise) criteria.uniqueResult();
		}
		if (req.getParameter("ordernum")!=null && !req.getParameter("ordernum").equals("")){
			choise.setOrdernum(Integer.parseInt(req.getParameter("ordernum")));
		}
		execute(choise,session);
		
		new HTTPGetRedirection(req, res, "ShowPurchase.do",null);
		return null;
	}
	
	public static void main(String[] args) {
		try {
				ApplicationContext context = new ClassPathXmlApplicationContext(
						new String[] { "applicationContext.xml",
								"applicationContext-localDataSource.xml" });
				SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
				Session session = sessionFactory.openSession();
				UpdateChoiseForOrdernumAction action = new UpdateChoiseForOrdernumAction();
				Criteria criteria = session.createCriteria(Choise.class);
				criteria.add(Restrictions.idEq(new Integer(1)));
				Choise choise = (Choise) criteria.uniqueResult();
				action.execute(choise, session);
				session.close();
				sessionFactory.close();
				sessionFactory =null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void execute(Choise choise,Session session){
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(choise);
		transaction.commit();
		session.flush();
	}
}