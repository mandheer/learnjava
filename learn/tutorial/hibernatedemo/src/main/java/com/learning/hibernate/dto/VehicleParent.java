/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author mandheer
 *         
 */
@Entity
/*
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * 
 * @DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType = DiscriminatorType.STRING)
 */
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public class VehicleParent {
	
	/**
	 * int : vehicleId
	 */
	@Id
	@GeneratedValue
	private int		vehicleId;
	/**
	 * String : vehicleName
	 */
	private String	vehicleName;
					
	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return this.vehicleId;
	}
	
	/**
	 * @param vehicleId
	 *            the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return this.vehicleName;
	}
	
	/**
	 * @param vehicleName
	 *            the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [vehicleId=");
		builder.append(this.vehicleId);
		builder.append(", vehicleName=");
		builder.append(this.vehicleName);
		builder.append("]");
		return builder.toString();
	}
	
}
