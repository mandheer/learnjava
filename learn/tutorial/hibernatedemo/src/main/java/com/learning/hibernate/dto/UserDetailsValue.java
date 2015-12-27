/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "USER_DETAILS_V")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class UserDetailsValue implements Serializable {
	
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
	private AddressValue		address;
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
	public UserDetailsValue() {
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
	 * @return the address
	 */
	public AddressValue getAddress() {
		return this.address;
	}
	
	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(AddressValue address) {
		this.address = address;
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
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [userId=");
		builder.append(this.userId);
		builder.append(", userName=");
		builder.append(this.userName);
		builder.append(", joinedDate=");
		builder.append(this.joinedDate);
		builder.append(", address=");
		builder.append(this.address);
		builder.append(", description=");
		builder.append(this.description);
		builder.append("]");
		return builder.toString();
	}
	
}
