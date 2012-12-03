package net.malta.web.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.malta.beans.AttachmentForm;
import net.malta.beans.ItemForm;
import net.malta.beans.ProductForm;
import net.malta.model.Attachment;
import net.malta.model.AttachmentImpl;
import net.malta.model.DbFile;
import net.malta.model.Item;
import net.malta.web.utils.AttachmentUtils;
import net.storyteller.desktop.CopyProperties;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class AttachmentFormFileUploadAddingToItemForDetailedAction extends Action{
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest req,
			HttpServletResponse res) throws Exception{
		
		Attachment attachment = new AttachmentImpl();
		AttachmentForm attachmentform = (AttachmentForm) form;
		
		Integer ItemInt = attachmentform.getAsdetailed();
		attachmentform.setAsdetailed(null);
		
//		attachment.setNumber(Integer.parseInt(req.getParameter("setNumber")));
		
		Session session = new HibernateSession().currentSession(this
				.getServlet().getServletContext());
		Criteria criteria2 = session.createCriteria(Item.class);
		criteria2.add(Restrictions.idEq(ItemInt));
		Item item = (Item) criteria2
				.uniqueResult();
		attachment.setAsdetailed(item);

		///////////////////////validation for file names jpgかJPGかJPEGじゃないなら
		if(! (attachmentform.getFormFiles()[0].getFileName().endsWith(".jpg") || attachmentform.getFormFiles()[0].getFileName().endsWith(".JPG") || attachmentform.getFormFiles()[0].getFileName().endsWith(".JPEG") )){
			req.getSession().setAttribute("error","画像はJPEG画像のみアップロード可能です。");
//			new HTTPGetRedirection(req, res, "##secoundmodelclass##Detail.do", attachmentform.getItem().toString());
			req.setAttribute("id",attachmentform.getAsdetailed());
			if(StringUtils.isNotBlank(req.getParameter("from")) && "detail".equals(req.getParameter("from"))){		
				ItemForm itemform = new ItemForm();
				new CopyProperties(item,itemform);
				req.setAttribute("form",itemform);
				return mapping.findForward("error");
			}else{
				return mapping.findForward("errorProduct");
			}
		}
		
		
		if(item.getDetailed().size() == 5){
			req.getSession().setAttribute("error","ファイルは五個までです。");
			if(StringUtils.isNotBlank(req.getParameter("from")) && "detail".equals(req.getParameter("from"))){
				ItemForm itemform = new ItemForm();
				new CopyProperties(item,itemform);
				req.setAttribute("form",itemform);
				return mapping.findForward("error");
			}else{
				ProductForm productForm = new ProductForm();
				new CopyProperties(item.getProduct(),productForm);
				req.setAttribute("form",productForm);
				return mapping.findForward("errorProduct");
			}
		}

		DbFile dbFile =  AttachmentUtils.createDbFileFromFormFile(attachmentform.getFormFiles()[0]);
		attachment.setDbFile(dbFile);
		attachment.setFiletype("jpg");
		
		Transaction transaction = session.beginTransaction();
		session.save(dbFile);
		session.save(attachment);
		transaction.commit();
		session.flush();


		
		
		if(StringUtils.isNotBlank(req.getParameter("from")) && "detail".equals(req.getParameter("from"))){		
			new HTTPGetRedirection(req, res, "PostItemDetail.do", item.getId().toString());
			return null;
		}
		
		new HTTPGetRedirection(req, res, "PostProductDetail.do", item.getProduct().getId().toString());
		return null;
	}
	
	
}