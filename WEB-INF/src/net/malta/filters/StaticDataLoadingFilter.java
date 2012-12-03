package net.malta.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import net.malta.model.StaticData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class StaticDataLoadingFilter implements Filter {
	public static final ThreadLocal thread = new ThreadLocal();
    private static Log log = LogFactory.getLog(PrivilegeManageFilter.class);
    private SessionFactory sessionFactory;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req2 = (HttpServletRequest)req;
		try {
			
			synchronized (thread) {
            	Session  session = (Session)thread.get();
            	if(session == null){
            		session = sessionFactory.openSession();
            		thread.set(session);
            	}
            	Criteria criteria = session.createCriteria(StaticData.class);
            	criteria.add(Restrictions.idEq(new Integer(1)));
            	StaticData data = (StaticData)criteria.uniqueResult();
            	session.refresh(data);
            	if(data!=null){
            		req.setAttribute("staticData",data);
        			chain.doFilter(req, res);
        			return;
            	}
			}
        } catch (StaleObjectStateException staleEx) {
            log.error("This interceptor does not implement optimistic concurrency control!");
            log.error("Your application will not work until you add compensation actions!");
            throw staleEx;
        } catch (Throwable ex) {
            // Rollback only
            ex.printStackTrace();
            // Let others handle it... maybe another interceptor for exceptions?
            throw new ServletException(ex);
        }
	}
	public void init(FilterConfig arg0) throws ServletException {
		BeanFactory factory = WebApplicationContextUtils
				.getWebApplicationContext(arg0.getServletContext());
		sessionFactory = (SessionFactory) factory
				.getBean("sessionFactory");
		
	}

}
