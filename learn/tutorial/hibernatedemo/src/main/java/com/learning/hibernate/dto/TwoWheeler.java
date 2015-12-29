/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import javax.persistence.Entity;

/**
 * @author mandheer
 *         
 */
@Entity
// @DiscriminatorValue(value = "BIKE")
public class TwoWheeler extends VehicleParent {
	/**
	 * String : steeringHandle
	 */
	private String steeringHandle;
	
	/**
	 * @return the steeringHandle
	 */
	public String getSteeringHandle() {
		return this.steeringHandle;
	}
	
	/**
	 * @param steeringHandle
	 *            the steeringHandle to set
	 */
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
