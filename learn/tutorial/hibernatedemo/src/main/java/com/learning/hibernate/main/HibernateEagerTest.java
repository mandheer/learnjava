/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.learning.hibernate.dto.AddressValue;
import com.learning.hibernate.dto.UserDetailsBasics;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateEagerTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetailsBasics userDetails = new UserDetailsBasics();
		AddressValue homeAddr = new AddressValue();
		AddressValue offAddr = new AddressValue();
		userDetails.setUserName("Third Name");
		
		userDetails.setDescription("This is the desription field.");
		userDetails.setJoinedDate(new Date());
		homeAddr.setStreet("St. john road");
		homeAddr.setCity("New York");
		homeAddr.setState("London");
		homeAddr.setPin("TNY 24H");
		offAddr.setStreet("Office Road");
		offAddr.setCity("New Jersey");
		offAddr.setState("USA");
		offAddr.setPin("TNY 25H");
		
		userDetails.getListOfAddresses().add(homeAddr);
		userDetails.getListOfAddresses().add(offAddr);
		
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(userDetails);
			session.getTransaction().commit();
			session.close();
			
			userDetails = null;
			session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
			userDetails = session.get(UserDetailsBasics.class, 1);
			session.close();
			System.out.println(userDetails.getListOfAddresses().size());
			
		} catch (Throwable t) {
			System.err.println("exception caught. " + t);
			t.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
			SessionFactoryCreatorDemo.shutdown();
		}
	}
	
}
