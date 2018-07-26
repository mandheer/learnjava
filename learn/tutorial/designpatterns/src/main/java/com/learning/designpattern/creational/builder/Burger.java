/**
 * 
 */
package com.learning.designpattern.creational.builder;

/**
 * @author mandheer
 *
 */
public abstract class Burger implements Item {

	/* (non-Javadoc)
	 * @see com.learning.designpattern.creational.builder.Item#packing()
	 */
	@Override
	public Packing packing() {
		return new PaperWrapper();
	}

}
