/**
 * hibernatedemo:com.learning.hibernate.util Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author mandheer
 *         
 */
public class SessionFactoryCreatorDemo {
	
	/**
	 * SessionFactory : SESSION_FACTORY
	 */
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
	
	/**
	 * No need to create instance.
	 */
	private SessionFactoryCreatorDemo() {
	
	}
	
	/**
	 * @return
	 *         
	 *         buildSessionFactory SessionFactoryCreatorDemo SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable t) {
			System.err.println("Initial SessionFactry creation Failed.");
			throw new ExceptionInInitializerError(t);
		}
	}
	
	/**
	 * @return
	 *         
	 *         getSessionFactory SessionFactoryCreatorDemo SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	/**
	 * 
	 *
	 * shutdown SessionFactoryCreatorDemo void
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}
	
}
