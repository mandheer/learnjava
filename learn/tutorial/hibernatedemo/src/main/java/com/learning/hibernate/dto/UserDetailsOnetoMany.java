/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "USER_DETAILS")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class UserDetailsOnetoMany implements Serializable {
	
	/**
	 * long : serialVersionUID
	 */
	private static final long	serialVersionUID	= 5203594244067931698L;
													
	/**
	 * int : userId
	 */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DETAILS")
	@Id
	private long				userId;
								
	/**
	 * String : userName
	 */
	private String				userName;
								
	/**
	 * Vehicle : vehicle
	 */
	@OneToOne
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle				vehicle;
								
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * default constructor
	 */
	public UserDetailsOnetoMany() {
	}
	
	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetailsEntity [userId=");
		builder.append(this.userId);
		builder.append(", userName=");
		builder.append(this.userName);
		builder.append(", vehicle=");
		builder.append(this.vehicle);
		builder.append("]");
		return builder.toString();
	}
	
}
