/**
 * hibernatedemo:com.learning.hibernate.util Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.util;

import com.learning.hibernate.dto.UserDetailsOnetoMany;
import com.learning.hibernate.dto.UserDetailsOnetoMany2;
import com.learning.hibernate.dto.VehicleManyToOne;
import com.learning.hibernate.dto.VehicleManyToOne2;

/**
 * @author mandheer
 *         
 */
public class EntityRelationalMapper {
	
	/**
	 * default constructor is private as this is utility class.
	 */
	private EntityRelationalMapper() {
	
	}
	
	/**
	 * @param user
	 *            oneToMany
	 * @param vehicle
	 *            
	 *            userVehicleMapper EntityRelationalMapper void
	 */
	public static void userVehicleMapper(UserDetailsOnetoMany user, VehicleManyToOne vehicle) {
		user.getVehicle().add(vehicle);
		vehicle.setOnetoManyUser(user);
	}
	
	public static void userVehicleMapper(UserDetailsOnetoMany2 user, VehicleManyToOne2 vehicle) {
		user.getVehicle().add(vehicle);
		vehicle.setOnetoManyUser(user);
	}
	
}
