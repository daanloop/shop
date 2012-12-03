package net.malta.web.utils;

import java.util.List;

import javax.servlet.ServletContext;

import net.enclosing.util.HibernateSession;
import net.malta.model.DeliveryAddress;
import net.malta.model.DeliveryAddressChoise;
import net.malta.model.Purchase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DeliveryAddressItem {
	public static List  thisdeliveryAddressItem(DeliveryAddress deliveryAddress,Purchase purchase,ServletContext context) {
//		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		Session session = new HibernateSession().currentSession(context);
		Criteria criteriachoises=session.createCriteria(DeliveryAddressChoise.class);
		criteriachoises.createCriteria("choise").add(Restrictions.eq("purchase", purchase));
		criteriachoises.add(Restrictions.eq("deliveryAddress",deliveryAddress));
		return criteriachoises.list();
	}
}
