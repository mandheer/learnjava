/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "USER_DETAILS_OTM2")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class UserDetailsOnetoMany2 implements Serializable {
	
	/**
	 * long : serialVersionUID
	 */
	private static final long				serialVersionUID	= 5203594244067931698L;
																
	/**
	 * int : userId
	 */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DETAILS")
	@Id
	private long							userId;
											
	/**
	 * String : userName
	 */
	private String							userName;
											
	/**
	 * Collection<VehicleManyToOne> : vehicle
	 */
	@OneToMany(mappedBy = "user")
	private Collection<VehicleManyToOne2>	vehicle				= new ArrayList<>();
																
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
	public UserDetailsOnetoMany2() {
	}
	
	/**
	 * @return the vehicle
	 */
	public Collection<VehicleManyToOne2> getVehicle() {
		return this.vehicle;
	}
	
	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	public void setVehicle(Collection<VehicleManyToOne2> vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetailsOnetoMany [userId=");
		builder.append(this.userId);
		builder.append(", userName=");
		builder.append(this.userName);
		builder.append(", vehicle=");
		builder.append(this.vehicle != null ? toString(this.vehicle, maxLen) : null);
		builder.append("]");
		return builder.toString();
	}
	
	private static String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0) {
				builder.append(", ");
			}
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}
	
}
