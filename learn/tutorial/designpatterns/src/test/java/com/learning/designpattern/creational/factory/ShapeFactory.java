package com.learning.designpattern.creational.factory;

import com.learning.designpattern.creational.model.Circle;
import com.learning.designpattern.creational.model.Rectangle;
import com.learning.designpattern.creational.model.Shape;
import com.learning.designpattern.creational.model.Square;

public class ShapeFactory {

    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if("CIRCLE".equalsIgnoreCase(shapeType)){
            return new Circle();
        }
        if("SQUARE".equalsIgnoreCase(shapeType)){
            return new Square();
        }
        if("RECTANGLE".equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }
        return null;
    }
}
