package net.malta.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;

import net.enclosing.util.HibernateSession;
import net.malta.model.PublicUser;
import net.malta.model.Purchase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class PurchaseDateSorter {
	public static String dateSorter(PublicUser publicUser,
			ServletContext context) throws ParseException {
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// new String[] { "applicationContext.xml",
		// "applicationContext-localDataSource.xml" });
		// SessionFactory sessionFactory = (SessionFactory)
		// context.getBean("sessionFactory");
		Session session = new HibernateSession().currentSession(context);
		String information = "no purchases";
		Criteria criteria = session.createCriteria(Purchase.class);
		criteria.add(Restrictions.eq("publicUser", publicUser)).addOrder(
				Order.desc("date")).setMaxResults(1);
		if (criteria.list().size() != 0) {
			Purchase purchase = (Purchase) criteria.uniqueResult();
			Date date = purchase.getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd hh:mm");
			information = dateFormat.format(purchase.getDate()).toString();

		}
		return information;
	}

	public static String dateSorter(PublicUser publicUser, Session session)
			throws ParseException {
		String information = "no purchases";
		Criteria criteria = session.createCriteria(Purchase.class);
		criteria.add(Restrictions.eq("publicUser", publicUser)).addOrder(
				Order.desc("date")).setMaxResults(1);
		if (criteria.list().size() != 0) {
			Purchase purchase = (Purchase) criteria.uniqueResult();
			Date date = purchase.getDate();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy/MM/dd hh:mm");
			information = dateFormat.format(purchase.getDate()).toString();

		}
		return information;
	}

}
