package net.malta.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateSessionRequestFilter implements Filter {
	public static final ThreadLocal thread = new ThreadLocal();
    private static Log log = LogFactory.getLog(HibernateSessionRequestFilter.class);

    private SessionFactory sf;

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        try {
            log.debug("Starting a database transaction");
            synchronized (thread) {
            	
            	Session  session = (Session)thread.get();
            	if(session == null){
            		System.err.println("mark 10000");
            		session = sf.openSession();
            		thread.set(session);
            	}
            	chain.doFilter(request, response);
            	log.debug("Committing the database transaction");
            }

        } catch (StaleObjectStateException staleEx) {
            log.error("This interceptor does not implement optimistic concurrency control!");
            log.error("Your application will not work until you add compensation actions!");
            // Rollback, close everything, possibly compensate for any permanent changes
            // during the conversation, and finally restart business conversation. Maybe
            // give the user of the application a chance to merge some of his work with
            // fresh data... what you do here depends on your applications design.
            throw staleEx;
        } catch (Throwable ex) {
            // Rollback only
            ex.printStackTrace();
            try {
/*                if (sf.getCurrentSession().getTransaction().isActive()) {
                    log.debug("Trying to rollback database transaction after exception");
                    sf.getCurrentSession().getTransaction().rollback();
                }*/
            } catch (Throwable rbEx) {
                log.error("Could not rollback transaction after exception!", rbEx);
            }

            // Let others handle it... maybe another interceptor for exceptions?
            throw new ServletException(ex);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    	System.err.println("mark 302 -----");
        log.debug("Initializing filter...");
        log.debug("Obtaining SessionFactory from static HibernateUtil singleton");
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml",
						"applicationContext-localDataSource.xml",
						"applicationContext-manageable.xml" });
        
        sf = (SessionFactory)appContext.getBean("sessionFactory");
    }

    public void destroy() {}

}
