/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import org.hibernate.Session;

import com.learning.hibernate.dto.UserDetailsEntity;
import com.learning.hibernate.dto.Vehicle;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateEntityOnetoOneTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetailsEntity userDetails = new UserDetailsEntity();
		userDetails.setUserName("Third Name");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bajaj Pulsar");
		userDetails.setVehicle(vehicle);
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(userDetails);
			session.save(vehicle);
			session.getTransaction().commit();
			session.close();
			
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
