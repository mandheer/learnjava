/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import org.hibernate.Session;

import com.learning.hibernate.dto.UserDetailsOnetoMany;
import com.learning.hibernate.dto.VehicleManyToOne;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateEntityOnetoManyNotFoundTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetailsOnetoMany userDetails = new UserDetailsOnetoMany();
		userDetails.setUserName("ForthUser");
		
		VehicleManyToOne vehicle = new VehicleManyToOne();
		vehicle.setVehicleName("Bajaj Pulsar");
		
		VehicleManyToOne vehicle2 = new VehicleManyToOne();
		vehicle2.setVehicleName("Maruti WagonR");
		
		userDetails.getVehicle().add(vehicle);
		userDetails.getVehicle().add(vehicle2);
		
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(userDetails);
			session.save(vehicle);
			session.save(vehicle2);
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
