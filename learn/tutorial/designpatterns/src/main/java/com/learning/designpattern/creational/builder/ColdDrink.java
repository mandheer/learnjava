package com.learning.designpattern.creational.builder;

public abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
		return new PlasticBottle();
	}

}
