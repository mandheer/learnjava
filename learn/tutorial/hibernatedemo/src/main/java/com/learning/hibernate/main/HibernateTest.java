/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;

import com.learning.hibernate.dto.UserDetails;

/**
 * @author mandheer
 *         
 */
public class HibernateTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetails userDetails = new UserDetails();
		
		userDetails.setUserId(1);
		userDetails.setUserName("First Name");
		
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable t) {
			System.err.println("Initial Session Factory creation failed. " + t);
			throw new ExceptionInInitializerError(t);
			
		}
		Assert.assertNotNull(sessionFactory);
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
	}
	
}
