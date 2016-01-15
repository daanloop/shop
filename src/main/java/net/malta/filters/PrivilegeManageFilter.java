package net.malta.filters;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.enclosing.util.HTTPGetRedirection;
import net.enclosing.util.HibernateSession;
import net.enclosing.util.StringFullfiller;
import net.malta.model.PublicUser;
import net.malta.model.PublicUserImpl;
import net.malta.model.Purchase;
import net.malta.model.PurchaseImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class PrivilegeManageFilter implements Filter {
	public static final ThreadLocal thread = new ThreadLocal();
    private static Log log = LogFactory.getLog(PrivilegeManageFilter.class);
    private  ServletContext context = null;

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req2 = (HttpServletRequest)req;
		HttpServletResponse res2 = (HttpServletResponse)res;
		if(req2.getRequestURI().replaceAll(".do","").endsWith("Login") || !req2.getRequestURI().contains(".do")){
			chain.doFilter(req, res);
		}else if(req.getParameter("login") == null || req.getParameter("ajax") == null){
			try {  

				synchronized (thread) {

					Session session = new HibernateSession().currentSession(this.context);

	            	String id = null;
	            	boolean cookieexists = false;
	            	if(req2.getCookies()!=null){

		            	for (int i = 0; i < req2.getCookies().length; i++) {
			    			if(req2.getCookies()[i].getName().equals("malta")){
			    				cookieexists = true;
			    				id = req2.getCookies()[i].getValue();
			    				break;
			    			}
						}
	            	}
	            	if(!cookieexists){
						System.err.println("mark 0----------------------------------------");

	            		if(req2.getSession().getAttribute("u") == null){
	            			Purchase purchase = new PurchaseImpl();
	            			PublicUser publicUser = new PublicUserImpl();
	            			StringFullfiller.fullfil(purchase);
	            			StringFullfiller.fullfil(publicUser);
	            			publicUser.setTemp(true);
	            			purchase.setTemp(true);
	            			purchase.setPublicUser(publicUser);
	            			Transaction transaction = session
									.beginTransaction();
							session.save(purchase);
							session.save(publicUser);
							
							transaction.commit();
							session.flush();

							Calendar calendarnum = Calendar.getInstance();
							Cookie cookie = new Cookie("malta",publicUser.getId().toString());
							cookie.setValue(publicUser.getId().toString());
							cookie.setComment("hoge");
							cookie.setMaxAge(60 * 60 * 168);

							res2.addCookie(cookie); 
//							new HTTPGetRedirection(req2, res2, "ProductList.do?category=1", null);
//							res2.getOutputStream().close();
							
							req2.getSession().setAttribute("u", publicUser);
							req2.getSession().setAttribute("purchase", purchase);
							res2.sendRedirect("ProductList.do?category=1");
							res2.flushBuffer();
							System.err.println("mark 1----------------------------------------");
							return;
							
	            			
	            		}else{
	            			System.err.println("hogehoge");
	            			session.refresh(req2.getSession().getAttribute("u"));
	            			if(req2.getSession().getAttribute("purchase") == null){
	            				Purchase purchase = new PurchaseImpl();
	            				purchase.setTemp(true);
	            				purchase.setPublicUser((PublicUser)req2.getSession().getAttribute("u"));
		            			StringFullfiller.fullfil(purchase);
	            				
	            				Transaction transaction = session.beginTransaction();
								session.save(purchase);
								transaction.commit();
								session.flush();
								req2.getSession().setAttribute("purchase", purchase);
								System.err.println("mark 2----------------------------------------");
	            			}
	            			session.refresh(req2.getSession().getAttribute("purchase"));
							System.err.println("mark 8----------------------------------------");
	            		}
	            	}else{
						System.err.println("mark 7----------------------------------------");

	            		if(req2.getSession().getAttribute("u") == null){
	            			Criteria criteriaPublicUser = session
									.createCriteria(PublicUser.class);
							criteriaPublicUser.add(Restrictions.eq("id", Integer.valueOf(id)));
							PublicUser publicUser = (PublicUser) criteriaPublicUser.uniqueResult();
							req2.getSession().setAttribute("u", publicUser);
							
	            			if(req2.getSession().getAttribute("purchase") == null){
	            				Purchase purchase = new PurchaseImpl();
	            				purchase.setTemp(true);
	            				purchase.setPublicUser(publicUser);
		            			StringFullfiller.fullfil(purchase);
	            				
	            				Transaction transaction = session.beginTransaction();
								session.save(purchase);
								transaction.commit();
								session.flush();
								req2.getSession().setAttribute("purchase", purchase);
								System.err.println("mark 3----------------------------------------");

	            			}else{
		            			session.refresh(req2.getSession().getAttribute("purchase"));
								System.err.println("mark 4----------------------------------------");

	            			}
	            		}else{
	            			session.refresh(req2.getSession().getAttribute("u"));
	            			if(req2.getSession().getAttribute("purchase") == null){
	            				Purchase purchase = new PurchaseImpl();
	            				purchase.setTemp(true);
	            				purchase.setPublicUser((PublicUser)req2.getSession().getAttribute("u"));
		            			StringFullfiller.fullfil(purchase);
	            				
	            				Transaction transaction = session.beginTransaction();
								session.save(purchase);
								transaction.commit();
								session.flush();
								req2.getSession().setAttribute("purchase", purchase);
								System.err.println("mark 5----------------------------------------");

	            			}else{
		            			session.refresh(req2.getSession().getAttribute("purchase"));
								System.err.println("mark 6----------------------------------------");

	            			}
	            		}
	            	}
	            	

	            	boolean  allowed = true;

//	            	Criteria criteria = session.createCriteria(IntraUser.class);
//	            	criteria.add(Restrictions.eq("mail",mailstr));
//	            	IntraUser intraUser = (IntraUser)criteria.uniqueResult();
//	            	req.setAttribute("u",intraUser);
//	            	req.setAttribute("p",intraUser.getPrivilege());
//	            	session.refresh(intraUser);
//	            	criteria = null;
	            	chain.doFilter(req, res);
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


		}else{
			chain.doFilter(req, res);
		}

	}
	public void init(FilterConfig arg0) throws ServletException {
		context = arg0.getServletContext();

	}


}
