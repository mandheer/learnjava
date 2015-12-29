/**
 * hibernatedemo:com.learning.hibernate.main Created on Dec 27, 2015
 */
package com.learning.hibernate.main;

import org.hibernate.Session;

import com.learning.hibernate.dto.FourWheeler;
import com.learning.hibernate.dto.TwoWheeler;
import com.learning.hibernate.dto.VehicleParent;
import com.learning.hibernate.util.SessionFactoryCreatorDemo;

/**
 * @author mandheer
 */
public class HibernateInheritanceTest {
	
	/**
	 * @param args
	 *            
	 *            main HibernateTest void
	 */
	public static void main(String[] args) {
		VehicleParent vehicleParent = new VehicleParent();
		vehicleParent.setVehicleName("This is Vehicle");
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike Two wheeler");
		twoWheeler.setSteeringHandle("handle bar");
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Car four wheeler");
		fourWheeler.setSteerinWheel("This is wheel");
		
		Session session = SessionFactoryCreatorDemo.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(vehicleParent);
			session.save(twoWheeler);
			session.save(fourWheeler);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			SessionFactoryCreatorDemo.shutdown();
		}
	}
	
}
