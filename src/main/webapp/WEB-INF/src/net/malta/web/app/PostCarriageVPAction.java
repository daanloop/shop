package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.beans.CarriageForm;
import net.malta.model.Carriage;
import net.malta.model.CarriageImpl;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PostCarriageVPAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		

		String error = "";
		
		if(StringUtils.isBlank(req.getParameter("a"))){
		   error += "値は空にはできません。<br />"; 
		}
		
		if(!StringUtils.isNumeric(req.getParameter("a"))){
		    error += "値には数値のみを入れてください。<br />";
		}
		if(StringUtils.isBlank(req.getParameter("b"))){
			   error += "値は空にはできません。<br />"; 
		}
			
		if(!StringUtils.isNumeric(req.getParameter("b"))){
		    error += "値には数値のみを入れてください。<br />";
		}
		if(StringUtils.isBlank(req.getParameter("c"))){
			error += "値は空にはできません。<br />"; 
		}

		if(!StringUtils.isNumeric(req.getParameter("c"))){
			error += "値には数値のみを入れてください。<br />";
		}

		
		if(StringUtils.isNotBlank(error)){
			req.getSession().setAttribute("error",error);
			return mapping.findForward("error");
		}
		
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		
		Criteria criteria = session.createCriteria(Carriage.class);
		criteria.add(Restrictions.eq("id", new Integer(1)));
		Carriage carriagea = (Carriage) criteria.uniqueResult();
		criteria = session.createCriteria(Carriage.class);
		criteria.add(Restrictions.eq("id", new Integer(2)));
		Carriage carriageb = (Carriage) criteria.uniqueResult();
		criteria = session.createCriteria(Carriage.class);
		criteria.add(Restrictions.eq("id", new Integer(3)));
		Carriage carriagec = (Carriage) criteria.uniqueResult();

//		if (req.getAttribute("form")== null && req.getParameter("id")!=null){
//			criteria.add(Restrictions.idEq(Integer.valueOf(req
//					.getParameter("id"))));
//			carriage = (Carriage) criteria.uniqueResult();
//			new CopyProperties(carriage,carriageform);
//		} else if(req.getAttribute("form")!=null){
		
//                        carriageform = (CarriageForm)req.getAttribute("form");
//			criteria.add(Restrictions.idEq(carriageform.getId()));
//			carriage = (Carriage) criteria.uniqueResult();
//		}
//		
		carriagea.setValue(Integer.parseInt(req.getParameter("a")));
		carriageb.setValue(Integer.parseInt(req.getParameter("b")));
		carriagec.setValue(Integer.parseInt(req.getParameter("c")));

                   
		StringFullfiller.fullfil(carriagea);
		StringFullfiller.fullfil(carriageb);
		StringFullfiller.fullfil(carriagec);
                

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(carriagea);
		session.saveOrUpdate(carriageb);
		session.saveOrUpdate(carriagec);
		transaction.commit();
		session.flush();

		new HTTPGetRedirection(req, res, "PostCarriageDetail.html", null);
		return null;
	}
}