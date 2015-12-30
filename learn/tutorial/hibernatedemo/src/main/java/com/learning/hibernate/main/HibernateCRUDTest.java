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
public class HibernateCRUDTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetails userDetails = null;
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			/*
			 * session.beginTransaction(); for (int i = 50; i <= 100; i++) { userDetails = new
			 * UserDetails(); userDetails.setUserName("User Name " + i); session.save(userDetails);
			 * } session.getTransaction().commit(); session.close();
			 */
			session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
			session.beginTransaction();
			userDetails = session.get(UserDetails.class, 51l);
			userDetails.setUserName("Updated User");
			// session.delete(userDetails);
			// session.update(userDetails);
			session.getTransaction().commit();
			session.close();
			System.out.println(userDetails);
		} finally {
			if (session.isOpen())
				session.close();
			SessionFactoryCreatorDemo.shutdown();
		}
	}
	
}
