/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.learning.hibernate.dto.UserDetails;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateHQLTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetails userDetails = null;
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
			session.beginTransaction();
			
			Query query = session.createQuery("from UserDetails where userId >49");
			List<UserDetails> list = query.list();
			
			session.close();
			System.out.println(list.size());
		} finally {
			if (session.isOpen())
				session.close();
			SessionFactoryCreatorDemo.shutdown();
		}
	}
	
}
