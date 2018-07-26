package com.learning.designpattern.creational.model;

import com.learning.designpattern.creational.builder.ColdDrink;

public class Pepsi extends ColdDrink {

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 35.5f;
	}

}
