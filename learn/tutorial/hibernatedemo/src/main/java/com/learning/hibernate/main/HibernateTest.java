/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import org.hibernate.Session;

import com.learning.hibernate.dto.UserDetails;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

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
		UserDetails userDetails = new UserDetails(2, "Second Name");
		
		userDetails.setUserId(1);
		userDetails.setUserName("First Name");
		
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		
		SessionFactoryCreatorDemo.shutdown();
	}
	
}
