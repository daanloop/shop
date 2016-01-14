package net.malta.web.utils;

import java.util.Iterator;

import net.malta.model.Choise;
import net.malta.model.DeliveryAddressChoise;

public class Choises {
	public static int remaining(Object choise) {
		Choise c = (Choise)choise;
		int remaining = c.getOrdernum();
		return (remaining-placed(choise));
	}
	
	public static int placed(Object choise) {
		Choise c = (Choise)choise;
		int placed = 0;
		for (Iterator iter = c.getDeliveryAddressChoises().iterator(); iter.hasNext();) {
			DeliveryAddressChoise dac = (DeliveryAddressChoise) iter.next();
			placed += dac.getOrdernum();
		}
		return placed;
	}
}