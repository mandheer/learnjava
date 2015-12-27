/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.learning.hibernate.dto.AddressValue;
import com.learning.hibernate.dto.UserDetailsValueOverride;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateValueOverrideTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetailsValueOverride userDetails = new UserDetailsValueOverride();
		AddressValue homeAddr = new AddressValue();
		AddressValue offAddr = new AddressValue();
		userDetails.setUserName("Third Name");
		userDetails.setHomeAddress(homeAddr);
		userDetails.setBusinessAddress(offAddr);
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
