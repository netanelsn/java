package com.hit.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static SessionFactory factory = null;
	private HibernateUtil() {
		
    }
	
	/**
	 * singleton SessionFactory object
	 * 
	 * */
	public static synchronized SessionFactory getSessionFactory() {
		 
        if (factory == null) {
        	
            try {
            	// Create the SessionFactory
            	factory = new AnnotationConfiguration().configure().buildSessionFactory();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
        	
        }
        return factory;
    }
	
}
