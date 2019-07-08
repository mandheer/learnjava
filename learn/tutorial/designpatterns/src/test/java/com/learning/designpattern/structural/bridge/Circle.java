package com.learning.designpattern.structural.bridge;

public class Circle extends Shape {

	int x,y,radius;
	
	protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x=x;
		this.y=y;
		this.radius=radius;
	}

	@Override
	public void draw() {
		drawAPI.drawCircle(radius, x, y);
	}

}
