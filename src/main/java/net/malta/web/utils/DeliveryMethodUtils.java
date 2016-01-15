package net.malta.web.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;

public class DeliveryMethodUtils {
	public static void setIntoSesssion(HttpServletRequest req) {
		if(StringUtils.isNotBlank(req.getParameter("deliverymethod"))){
			Integer deliverymethodInteger = Integer.valueOf(req.getParameter("deliverymethod"));
			req.getSession().setAttribute("deliverymethod", deliverymethodInteger);
		}
	}
}
