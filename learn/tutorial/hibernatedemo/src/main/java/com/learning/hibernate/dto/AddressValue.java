/**
 * hibernatedemo:com.learning.hibernate.dto Created on Dec 27, 2015
 *
 * 
 */
package com.learning.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author mandheer
 *         
 */
@Embeddable
public class AddressValue {
	
	/**
	 * String : street
	 */
	@Column(name = "STREET_NAME")
	private String	street;
	/**
	 * String : city
	 */
	@Column(name = "CITY_NAME")
	private String	city;
	/**
	 * String : state
	 */
	@Column(name = "STATE_NAME")
	private String	state;
	/**
	 * String : pin
	 */
	@Column(name = "PINCODE")
	private String	pin;
					
	/**
	 * @return the street
	 */
	public String getStreet() {
		return this.street;
	}
	
	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return this.state;
	}
	
	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the pin
	 */
	public String getPin() {
		return this.pin;
	}
	
	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddressValue [street=");
		builder.append(this.street);
		builder.append(", city=");
		builder.append(this.city);
		builder.append(", state=");
		builder.append(this.state);
		builder.append(", pin=");
		builder.append(this.pin);
		builder.append("]");
		return builder.toString();
	}
	
}
