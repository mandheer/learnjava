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
// @DiscriminatorValue("CAR")
public class FourWheeler extends VehicleParent {
	/**
	 * String : steerinWheel
	 */
	private String steerinWheel;
	
	/**
	 * @return the steerinWheel
	 */
	public String getSteerinWheel() {
		return this.steerinWheel;
	}
	
	/**
	 * @param steerinWheel
	 *            the steerinWheel to set
	 */
	public void setSteerinWheel(String steerinWheel) {
		this.steerinWheel = steerinWheel;
	}
}
