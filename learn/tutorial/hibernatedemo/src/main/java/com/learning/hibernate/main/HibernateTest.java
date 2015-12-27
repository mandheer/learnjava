/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import java.util.Date;

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
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("Third Name");
		userDetails.setAddress("New York");
		userDetails.setDescription("This is the desription field.");
		userDetails.setJoinedDate(new Date());
		
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(userDetails);
			session.getTransaction().commit();
			session.close();
			
			userDetails = null;
			session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
			session.beginTransaction();
			// userDetails = session.get(UserDetails.class, 1);
			System.out.println(userDetails);
		} finally {
			session.close();
			SessionFactoryCreatorDemo.shutdown();
		}
	}
	
}
