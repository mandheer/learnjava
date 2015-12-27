/**
 * hibernatedemo:com.learning.hibernate.util Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.util;

import com.learning.hibernate.dto.UserDetailsOnetoMany;
import com.learning.hibernate.dto.VehicleManyToOne;

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
	 * @param vehicle
	 *            
	 *            UserVehicleMapper EntityRelationalMapper void
	 */
	public static void UserVehicleMapper(UserDetailsOnetoMany user, VehicleManyToOne vehicle) {
		user.getVehicle().add(vehicle);
	}
	
}
