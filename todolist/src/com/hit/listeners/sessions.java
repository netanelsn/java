package com.hit.listeners;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class sessions
 *
 */
@WebListener
public class sessions implements HttpSessionListener, HttpSessionAttributeListener {
	
    /**
     * Default constructor. 
     */
    public sessions() {
        // TODO Auto-generated constructor stub
    }
   
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent event)  { 
    	System.out.println("sessionCreated - add one session into counter");
    	
    	HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
        
        synchronized (this) {
        	if(application.getAttribute("sessions")==null) {
           	 	application.setAttribute("sessions",new HashSet<HttpSession>());
            }
            @SuppressWarnings("unchecked")
    		Set<HttpSession> set = (Set<HttpSession>)application.getAttribute("sessions");
            set.add(session);
        }
        
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent event)  { 
    	System.out.println("sessionDestroyed - deduct one session from counter");
    	
    	HttpSession session = event.getSession();
        ServletContext application = session.getServletContext();
		@SuppressWarnings("unchecked")
		Set<HttpSession> set = (HashSet<HttpSession>)application.getAttribute("sessions");
        set.remove(session);
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionAttributeAdded" + event.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("sessionAttributeRemoved" + event.getValue());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }
	
}
