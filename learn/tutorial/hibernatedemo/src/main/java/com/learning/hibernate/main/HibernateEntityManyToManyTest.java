/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.main;

import org.hibernate.Session;

import com.learning.hibernate.dto.UserDetailsManytoMany;
import com.learning.hibernate.dto.VehicleManyToMany;
import com.learning.hibernate.util.EntityRelationalMapper;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 *         
 */
public class HibernateEntityManyToManyTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		UserDetailsManytoMany userDetails = new UserDetailsManytoMany();
		userDetails.setUserName("Forth User");
		UserDetailsManytoMany userDetails2 = new UserDetailsManytoMany();
		userDetails2.setUserName("Fifth User");
		VehicleManyToMany vehicle = new VehicleManyToMany();
		vehicle.setVehicleName("Bajaj Pulsar");
		VehicleManyToMany vehicle2 = new VehicleManyToMany();
		vehicle2.setVehicleName("Maruti WagonR");
		
		EntityRelationalMapper.userVehicleMapper(userDetails, vehicle);
		EntityRelationalMapper.userVehicleMapper(userDetails, vehicle2);
		EntityRelationalMapper.userVehicleMapper(userDetails2, vehicle);
		EntityRelationalMapper.userVehicleMapper(userDetails2, vehicle2);
		
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(userDetails);
			session.save(userDetails2);
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
