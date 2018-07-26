package com.learning.designpattern.creational.abstractfactory;

import com.learning.designpattern.creational.model.Color;
import com.learning.designpattern.creational.model.Shape;

/**
 * Abstract Factory patterns work around a super-factory which creates other factories.
 * This factory is also called as factory of factories.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes.
 * Each generated factory can give the objects as per the Factory pattern.
 *
 * This class would be responsible for AbstractFactoryDemo.
 *
 * The output should be like below :
 * Inside Circle::draw() method.
 * Inside Square::draw() method.
 * Inside Rectangle:: draw() method.
 * Inside Red::fill() method.
 * Inside Blue::fill() method.
 * Inside Green::fill() method.
 *
 * @author mandheer
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args){

        //Get ShapeFatory from AbstractFactory
        AbstractFactory afShape = FactoryProducer.getFactory("SHAPE");

        //Get an object of Shape Circle
        Shape circle = afShape.getShape("CIRCLE");

        //Call draw method of shape Circle
        circle.draw();

        //Get an object of Shape Square
        Shape square = afShape.getShape("SQUARE");

        //Call draw method of shape Square
        square.draw();

        //Get an object of Shape Rectangle
        Shape rectangle = afShape.getShape("RECTANGLE");

        //Call draw method of shape Rectangle
        rectangle.draw();

        AbstractFactory afColor = FactoryProducer.getFactory("COLOR");

        //Get an object of Color Red
        Color red = afColor.getColor("RED");

        //Call the fill method of color red
        red.fill();

        //Get and object of Color Blue
        Color blue = afColor.getColor("BLUE");

        //Call the fill method of color blue
        blue.fill();

        //Get an object of Color Green
        Color green = afColor.getColor("GREEN");

        //Call the fill method of Color Green
        green.fill();
    }
}
