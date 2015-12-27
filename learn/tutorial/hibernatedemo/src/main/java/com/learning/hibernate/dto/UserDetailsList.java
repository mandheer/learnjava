/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

/**
 * @author mandheer
 *         
 */
@Entity
@Table(name = "USER_DETAILS_L")
@SequenceGenerator(name = "SEQ_USER_DETAILS", sequenceName = "SEQ_UD", initialValue = 1, allocationSize = 1)
public class UserDetailsList implements Serializable {
	
	/**
	 * long : serialVersionUID
	 */
	private static final long			serialVersionUID	= 5203594244067931698L;
															
	/**
	 * int : userId
	 */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DETAILS")
	@Id
	private long						userId;
										
	/**
	 * String : userName
	 */
	private String						userName;
										
	/**
	 * Date : joinedDate
	 */
	@Temporal(TemporalType.DATE)
	private Date						joinedDate;
										
	/**
	 * Set<AddressValue> : listOfAddresses
	 */
	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns = { @JoinColumn(name = "USER_ID") })
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "SEQ_USER_DETAILS", type = @Type(type = "long") )
	private Collection<AddressValue>	listOfAddr			= new ArrayList<>();
															
	/**
	 * String : description
	 */
	@Lob
	private String						description;
										
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
	public UserDetailsList() {
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
	 * @return the listOfAddresses
	 */
	public Collection<AddressValue> getListOfAddresses() {
		return this.listOfAddr;
	}
	
	/**
	 * @param listOfAddresses
	 *            the listOfAddresses to set
	 */
	public void setListOfAddresses(Collection<AddressValue> listOfAddresses) {
		this.listOfAddr = listOfAddresses;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetailsList [userId=");
		builder.append(this.userId);
		builder.append(", userName=");
		builder.append(this.userName);
		builder.append(", joinedDate=");
		builder.append(this.joinedDate);
		builder.append(", listOfAddresses=");
		builder.append(this.listOfAddr != null ? this.toString(this.listOfAddr, maxLen) : null);
		builder.append(", description=");
		builder.append(this.description);
		builder.append("]");
		return builder.toString();
	}
	
	private String toString(Collection<?> collection, int maxLen) {
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
