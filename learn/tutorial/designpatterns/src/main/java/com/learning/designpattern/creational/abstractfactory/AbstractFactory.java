package com.learning.designpattern.creational.abstractfactory;

import com.learning.designpattern.creational.model.Color;
import com.learning.designpattern.creational.model.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
