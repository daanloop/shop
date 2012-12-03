package net.malta.web.utils;

import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.enclosing.util.HibernateSession;
import net.malta.model.PublicUser;
import net.malta.model.Purchase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SessionData {


	public static void update(Purchase purchase, PublicUser publicUser,Session session) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] { "applicationContext.xml",
//						"applicationContext-localDataSource.xml" });
//		Session session = new HibernateSession().currentSession(context);
		purchase.setPublicUser(publicUser);

		session.evict(purchase);
		session.refresh(purchase);
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(purchase);
		transaction.commit();

		session.evict(publicUser);
		session.refresh(publicUser);
		session.evict(purchase);
		session.refresh(publicUser);

		session.flush();
	}

	public static void updateCookie(PublicUser publicUser,
			HttpServletRequest req, HttpServletResponse res) {

		
		Calendar calendarnum = Calendar.getInstance();
		Cookie cookie = new Cookie("malta",publicUser.getId().toString());
		cookie.setValue(publicUser.getId().toString());
		cookie.setComment("hoge");
		cookie.setMaxAge(60 * 60 * 168);

		res.addCookie(cookie); 
		try {
			res.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	public static void update(PublicUser u, Purchase purchase,
			HttpServletRequest req, HttpServletResponse res,Session session) {
		update(purchase, u,session);
		updateCookie(u, req, res);

		req.getSession().setAttribute("u", u);
		req.getSession().setAttribute("purchase", purchase);
	}
}
