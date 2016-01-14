package net.malta.web.app;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LogoutAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		req.getSession().setAttribute("u",null);
		Calendar calendarnum = Calendar.getInstance();
		Cookie cookie = new Cookie("malta","");
//		cookie.setValue(intraUser.getMail());
		cookie.setMaxAge(0);
		cookie.setComment("hogehoge");
		res.addCookie(cookie); 
		res.flushBuffer();
		new HTTPGetRedirection(req, res, "Login.do?login=true&ajax=true", "");
		return null;
	}
	
	
}
