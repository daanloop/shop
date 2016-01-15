package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HibernateSession;
import net.malta.model.Attachment;
import net.malta.model.StaticData;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ShowImage extends Action {
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception {
	// TODO Auto-generated method stub
	Session session = new HibernateSession().currentSession(this.getServlet()
			.getServletContext(),3);
	String id=req.getParameter("id");
	
	if (id != null && id.length() > 0) {
		Attachment attachment = (Attachment)session.createCriteria(Attachment.class).add(Restrictions.idEq(Integer.valueOf(id))).uniqueResult();
		if (attachment != null) {
			res.setContentType("image/jpeg");
			res.getOutputStream().write(attachment.getDbFile().getData());
			return null;
		}	
	}
	res.setContentType("image/jpeg");
	Criteria criteriaStaticData = session.createCriteria(StaticData.class);
	criteriaStaticData.add(Restrictions.eq("id", new Integer(1)));
	StaticData staticData = (StaticData) criteriaStaticData.uniqueResult();
	res.getOutputStream().write(staticData.getNoimage());
	return null;
	}
}
