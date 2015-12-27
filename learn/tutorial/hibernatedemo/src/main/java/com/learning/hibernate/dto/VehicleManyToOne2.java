/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "VEHICLE_DETAILS_2")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class VehicleManyToOne2 implements Serializable {
	
	/**
	 * long : serialVersionUID
	 */
	private static final long		serialVersionUID	= -1396218071821079244L;
														
	/**
	 * int : vehicleId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DETAILS")
	@Column(name = "VEHICLE_ID")
	private int						vehicleId;
	/**
	 * String : vehicleName
	 */
	@Column(name = "VEHICLE_NAME")
	private String					vehicleName;
									
	/**
	 * UserDetailsOnetoMany : onetoManyUser
	 */
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserDetailsOnetoMany2	user;
									
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
	 * @return the onetoManyUser
	 */
	public UserDetailsOnetoMany2 getOnetoManyUser() {
		return this.user;
	}
	
	/**
	 * @param onetoManyUser
	 *            the onetoManyUser to set
	 */
	public void setOnetoManyUser(UserDetailsOnetoMany2 onetoManyUser) {
		this.user = onetoManyUser;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleManyToOne [vehicleId=");
		builder.append(this.vehicleId);
		builder.append(", vehicleName=");
		builder.append(this.vehicleName);
		builder.append(", onetoManyUser=");
		builder.append(this.user);
		builder.append("]");
		return builder.toString();
	}
	
}
