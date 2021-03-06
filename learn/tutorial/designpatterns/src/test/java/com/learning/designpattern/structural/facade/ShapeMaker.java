package com.learning.designpattern.structural.facade;

public class ShapeMaker {
    private Shape rectangle;
    private Shape circle;
    private Shape square;

    public ShapeMaker(){
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
