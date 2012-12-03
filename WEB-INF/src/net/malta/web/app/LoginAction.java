package net.malta.web.app;
import java.util.Calendar;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.model.PublicUser;
import net.malta.model.Purchase;
import net.malta.web.utils.SessionData;
import net.malta.beans.PublicUserForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class LoginAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());


		PublicUserForm publicUserForm = (PublicUserForm)form;


		Criteria criteria = session.createCriteria(PublicUser.class);
		criteria.add(Restrictions.eq("registed", new Boolean(true)));
		criteria.add(Restrictions.eq("temp", new Boolean(false)));
		criteria.add(Restrictions.eq("mail",publicUserForm.getMail()));
		criteria.add(Restrictions.eq("password",publicUserForm.getPassword()));
		criteria.add(Restrictions.eq("removed", new Boolean(false)));
		criteria.setMaxResults(1);

		PublicUser publicUser = null;
		if(criteria.uniqueResult() !=null){
			publicUser = (PublicUser)criteria.uniqueResult();
			Purchase purchase = (Purchase)req.getSession().getAttribute("purchase");
			//purchase.setPublicUser(publicUser);
			SessionData.update(publicUser,purchase,req, res,session);
        	//req.getSession().setAttribute("u", publicUser);
			//req.getSession().setAttribute("purchase", purchase);
			
			/*
			if(publicUser.isRemoved()){
				req.setAttribute("message","そのユーザはメールアドレスの認証が済んでいません。");
				return mapping.findForward("error");
			}
			*/

		}else{

			if(publicUserForm.getMail() != null){
				req.setAttribute("message","ユーザが存在しないか、パスワードが間違っています。");
			}
			//return mapping.findForward("error");
			new HTTPGetRedirection(req,res,"PostPublicUserDetail.do",null);
			return null;
		}
		//session.flush();
		//new HTTPGetRedirection(req,res,"index.jsp","");
		
		new HTTPGetRedirection(req,res,"PostPublicUserDetail.do",null,"login=t");
		return null;
	}


}
