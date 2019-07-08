package com.learning.designpattern.creational.factory;

import com.learning.designpattern.creational.model.Shape;

/**
 * Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.

 * This class would be responsible for running the demo for Factory pattern.
 *
 * the output should look like below
 *
 * Inside Circle::draw() method.
 * Inside Square::draw() method.
 * Inside Rectangle:: draw() method.
 *
 * @author mandheer
 */
public class FactoryPatternDemo {

    public static void main(String [] args){
        //Get the instance of shapeFatory.
        ShapeFactory sf = new ShapeFactory();

        //Get the shape of desire by passing the type parameter
        Shape circle = sf.getShape("CIRCLE");

        //call the draw method on circle.
        circle.draw();

        Shape square = sf.getShape("SQUARE");
        //call the draw method on Square.
        square.draw();

        Shape rectangle = sf.getShape("RECTANGLE");
        //call the draw method on rectangle.
        rectangle.draw();
    }
}
