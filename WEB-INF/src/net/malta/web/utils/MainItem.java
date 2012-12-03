package net.malta.web.utils;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import net.enclosing.util.HibernateSession;
import net.malta.model.Item;
import net.malta.model.Product;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainItem {
	public static Item Of(Object object,ServletContext context) {
		Product product = (Product)object;
		if(product==null || product.getId()==null)
			return null;
		
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				new String[] { "applicationContext.xml",
//						"applicationContext-localDataSource.xml" }); 
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
//		Session session = sessionFactory.openSession();
		Session session = new HibernateSession().currentSession(context);
		
		Criteria criteriaItem = session.createCriteria(Item.class);
		criteriaItem.add(Restrictions.eq("product", product));
		criteriaItem.add(Restrictions.eq("main", new Boolean(true)));
		
		return (Item)criteriaItem.uniqueResult(); 
	}
	public static Item Of(Object object,Session session) {
		Product product = (Product)object;
		if(product==null || product.getId()==null)
			return null;
		
		Criteria criteriaItem = session.createCriteria(Item.class);
		criteriaItem.add(Restrictions.eq("product", product));
		criteriaItem.add(Restrictions.eq("main", new Boolean(true)));
		
		return (Item)criteriaItem.uniqueResult(); 
	}

}

