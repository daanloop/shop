package net.enclosing.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;

public class Error extends TagSupport {
	private String key = null;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			String value=(String)((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(this.key);
			StringBuilder builder = new StringBuilder();
			if(value!=null && StringUtils.isNotBlank(value)) {
				builder.append(value);
			}
			((HttpServletRequest)pageContext.getRequest()).getSession().removeAttribute(this.key);
			pageContext.getOut().print(builder.toString());
			System.err.println("yes!-----------------------------------------");
		}catch (Exception e) {
			e.printStackTrace();
			System.err.println("no!!-----------------------------------------");
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
	
	@Override
	public void setPageContext(PageContext pageContext){
		this.pageContext=pageContext;
	}
}
