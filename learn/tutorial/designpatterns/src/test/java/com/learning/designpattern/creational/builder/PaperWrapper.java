/**
 * 
 */
package com.learning.designpattern.creational.builder;

/**
 * @author mandheer
 *
 */
public class PaperWrapper implements Packing {

	/* (non-Javadoc)
	 * @see com.learning.designpattern.creational.builder.Packing#pack()
	 */
	@Override
	public String pack() {
		return "PaperWrapper";
	}

}
