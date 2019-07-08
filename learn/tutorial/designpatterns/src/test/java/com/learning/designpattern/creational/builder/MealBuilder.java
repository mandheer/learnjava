package com.learning.designpattern.creational.builder;

import com.learning.designpattern.creational.model.ChickenBurger;
import com.learning.designpattern.creational.model.Coke;
import com.learning.designpattern.creational.model.Pepsi;
import com.learning.designpattern.creational.model.VegBurger;

public class MealBuilder {
	
	public Meal prepareVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	public Meal prepareNonVegMeal(){
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}

}
