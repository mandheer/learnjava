/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 28, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "VEHICLE_MTM")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class VehicleManyToMany implements Serializable {
	
	/**
	 * long : serialVersionUID
	 */
	private static final long					serialVersionUID	= -1396218071821079244L;
																	
	/**
	 * int : vehicleId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DETAILS")
	@Column(name = "VEHICLE_ID")
	private int									vehicleId;
	/**
	 * String : vehicleName
	 */
	@Column(name = "VEHICLE_NAME")
	private String								vehicleName;
												
	/**
	 * Collection<UserDetailsManytoMany> : user
	 */
	@ManyToMany(mappedBy = "vehicle")
	private Collection<UserDetailsManytoMany>	user				= new ArrayList<>();
																	
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
	 * @return the user
	 */
	public Collection<UserDetailsManytoMany> getUser() {
		return this.user;
	}
	
	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(Collection<UserDetailsManytoMany> user) {
		this.user = user;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleManyToMany [vehicleId=");
		builder.append(this.vehicleId);
		builder.append(", vehicleName=");
		builder.append(this.vehicleName);
		builder.append(", user=");
		builder.append(this.user != null ? toString(this.user, maxLen) : null);
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
