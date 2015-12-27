/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "USER_DETAILS_VO")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class UserDetailsValueOverride implements Serializable {
	
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
	 * Date : joinedDate
	 */
	@Temporal(TemporalType.DATE)
	private Date				joinedDate;
	/**
	 * String : address
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME") ),
	        @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME") ),
	        @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME") ),
	        @AttributeOverride(name = "pin", column = @Column(name = "HOME_PINCODE") ) })
	private AddressValue		homeAddress;
								
	/**
	 * AddressValue : businessAddress
	 */
	@Embedded
	private AddressValue		businessAddress;
	/**
	 * String : description
	 */
	@Lob
	private String				description;
								
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
	public UserDetailsValueOverride() {
	}
	
	/**
	 * @return the joinedDate
	 */
	public Date getJoinedDate() {
		return this.joinedDate;
	}
	
	/**
	 * @param joinedDate
	 *            the joinedDate to set
	 */
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the homeAddress
	 */
	public AddressValue getHomeAddress() {
		return this.homeAddress;
	}
	
	/**
	 * @param homeAddress
	 *            the homeAddress to set
	 */
	public void setHomeAddress(AddressValue homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	/**
	 * @return the businessAddress
	 */
	public AddressValue getBusinessAddress() {
		return this.businessAddress;
	}
	
	/**
	 * @param businessAddress
	 *            the businessAddress to set
	 */
	public void setBusinessAddress(AddressValue businessAddress) {
		this.businessAddress = businessAddress;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetailsValueOverride [userId=");
		builder.append(this.userId);
		builder.append(", userName=");
		builder.append(this.userName);
		builder.append(", joinedDate=");
		builder.append(this.joinedDate);
		builder.append(", homeAddress=");
		builder.append(this.homeAddress);
		builder.append(", businessAddress=");
		builder.append(this.businessAddress);
		builder.append(", description=");
		builder.append(this.description);
		builder.append("]");
		return builder.toString();
	}
	
}
