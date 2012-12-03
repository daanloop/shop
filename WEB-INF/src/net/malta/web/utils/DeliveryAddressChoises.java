package net.malta.web.utils;

import java.util.Collection;

import javax.servlet.ServletContext;

import net.enclosing.util.HibernateSession;
import net.malta.model.DeliveryAddress;
import net.malta.model.DeliveryAddressChoise;
import net.malta.model.Purchase;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DeliveryAddressChoises {
	public static Collection Of(Purchase purchase,DeliveryAddress deliveryAddress,ServletContext context){

		Session session = new HibernateSession().currentSession(context);
		Criteria criteriaDeliveryAddressChoise = session.createCriteria(DeliveryAddressChoise.class);
		criteriaDeliveryAddressChoise.add(Restrictions.in("choise", purchase.getChoises()));
		criteriaDeliveryAddressChoise.add(Restrictions.eq("deliveryAddress", deliveryAddress));
		return criteriaDeliveryAddressChoise.list();
	}
}
