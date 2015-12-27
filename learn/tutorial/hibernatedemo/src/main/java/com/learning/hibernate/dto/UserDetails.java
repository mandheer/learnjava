/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author mandheer
 *         
 */
@Entity
public class UserDetails {
	
	@Id
	private int		userId;
	private String	userName;
					
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return this.userId;
	}
	
	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
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
}
