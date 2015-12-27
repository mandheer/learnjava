/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "VEHICLE_DETAILS")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class VehicleManyToOne {
	
	/**
	 * int : vehicleId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DETAILS")
	@Column(name = "VEHICLE_ID")
	private int		vehicleId;
	/**
	 * String : vehicleName
	 */
	@Column(name = "VEHICLE_NAME")
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
