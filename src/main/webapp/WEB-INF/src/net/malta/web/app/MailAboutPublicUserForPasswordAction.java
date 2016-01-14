package net.malta.web.app;

import net.malta.model.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.SimpleMail;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MailAboutPublicUserForPasswordAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{

		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		PublicUser publicUser = new PublicUserImpl();
		if (req.getParameter("mail") != null
				&& !req.getParameter("mail").equals("")) {
			Criteria criteriaPublicUser = session.createCriteria(PublicUser.class);
			criteriaPublicUser.add(Restrictions.eq("mail", req.getParameter("mail")));
			criteriaPublicUser.add(Restrictions.eq("removed", new Boolean(false)));
			criteriaPublicUser.add(Restrictions.eq("registed", new Boolean(true)));
			criteriaPublicUser.setMaxResults(1);
			if (criteriaPublicUser.list().size()==0) {
				String error="メールアドレスが存在しません";
				req.getSession().setAttribute("error", error);
				new HTTPGetRedirection(req, res, "ShowPublicUserForPassword.do", null);
				return null;
			}
			
			publicUser = (PublicUser) criteriaPublicUser.uniqueResult();
			
			publicUser.setPasswordonetimehash(RandomStringUtils.randomAlphanumeric(40));
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(publicUser);
			transaction.commit();
			session.flush();
			
			this.execute(publicUser.getId(),this.getServlet().getServletContext());
		}else{
			this.execute(null,this.getServlet().getServletContext());
		}

		return mapping.findForward("success");
	}
	public static void main(String[] args) {
		try {
				ApplicationContext context = new ClassPathXmlApplicationContext(
						new String[] { "applicationContext.xml",
								"applicationContext-localDataSource.xml" });
				MailAboutPublicUserForPasswordAction action = new MailAboutPublicUserForPasswordAction();
				action.execute(new Integer(1),context);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void execute(Integer id,ServletContext context){
		BeanFactory factory = WebApplicationContextUtils.getWebApplicationContext(context);
		this.execute(id, factory);
		
	}

	public void execute(Integer id,BeanFactory factory){
		SimpleMail mail = SimpleMail.create(new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "applicationContext-localDataSource.xml", "applicationContext-mail.xml" }));

		Session session = new HibernateSession().currentSession(factory);
		Criteria criteria = session.createCriteria(PublicUser.class);
		criteria.add(Restrictions.eq("id", id));
		PublicUser publicUser = (PublicUser) criteria.uniqueResult();
		Map model = new HashMap();
		model.put("publicUser", publicUser);
		model.put("dateFormatter", new SimpleDateFormat("yyyy/MM/dd"));
		model.put("timeFormatter", new SimpleDateFormat("hh:mm"));

		Criteria criteriastaticData = session.createCriteria(StaticData.class);
		criteriastaticData.add(Restrictions.eq("id", new Integer(1)));
		StaticData staticData = (StaticData) criteriastaticData.uniqueResult();
		

		model.put("staticData", staticData);

                //enjoy coding here....

		try {
			mail.send("MailaboutPublicUserForPassword-ja.eml", publicUser.getMail(), model);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
