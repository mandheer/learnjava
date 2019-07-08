package com.learning.designpattern.creational.model;

import com.learning.designpattern.creational.builder.Burger;

public class ChickenBurger extends Burger {

	@Override
	public String name() {
		return "NonVegBurger";
	}

	@Override
	public float price() {
		return 50.5f;
	}

}
