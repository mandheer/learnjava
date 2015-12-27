/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import org.hibernate.Session;

import com.learning.hibernate.dto.UserDetailsOnetoMany2;
import com.learning.hibernate.dto.VehicleManyToOne2;
import com.learning.hibernate.util.EntityRelationalMapper;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateEntityManyToOneTest2 {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetailsOnetoMany2 userDetails = new UserDetailsOnetoMany2();
		userDetails.setUserName("ForthUser");
		
		VehicleManyToOne2 vehicle = new VehicleManyToOne2();
		vehicle.setVehicleName("Bajaj Pulsar");
		VehicleManyToOne2 vehicle2 = new VehicleManyToOne2();
		vehicle2.setVehicleName("Maruti WagonR");
		
		EntityRelationalMapper.userVehicleMapper(userDetails, vehicle);
		EntityRelationalMapper.userVehicleMapper(userDetails, vehicle2);
		
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
