package net.malta.web.app;

import net.enclosing.util.HibernateSession;
import net.enclosing.util.MergeXls;
import net.malta.model.Item;
import net.malta.model.ItemImpl;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class XlsShowItemAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Item item = new ItemImpl();
		Session session = new HibernateSession().currentSession(this.getServlet().getServletContext());
		Criteria criteria = session.createCriteria(Item.class);

		if (req.getParameter("id") != null
				&& !req.getParameter("id").equals("")) {
			criteria.add(Restrictions.idEq(Integer.valueOf(req
					.getParameter("id"))));
			item = (Item) criteria.uniqueResult();

		} else if (req.getAttribute("id") != null
				&& !req.getAttribute("id").equals("")) {
			criteria.add(Restrictions.idEq(req.getAttribute("id")));
			item = (Item) criteria.uniqueResult();
		}
		
		Map map = new HashMap();
		map.put("item.name",item.getName());
		//map.put("item.attr1",item.getAttr1());
		
		
		File file = new File(this.getServlet().getServletContext().getRealPath("XlsShowItem.xls"));
		res.setHeader("Pragma", ""); 
		res.setHeader("Cache-Control", ""); 
		res.setHeader("Content-Disposition","attachment; filename=XlsShowItem.xls");
		MergeXls mergeXls =new MergeXls(file,res.getOutputStream(),map);
		
		for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {
			String element = (String) iter.next();
			System.err.println("key" + element + " : content" + map.get(element));
			
		}
		
		return null;
		
	}
}

