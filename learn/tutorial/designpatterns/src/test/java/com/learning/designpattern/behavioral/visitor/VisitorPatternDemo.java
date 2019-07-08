package com.learning.designpattern.behavioral.visitor;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        ComputerPart part = new Computer();
        part.accept(new ComputerPartDisplayVisitor());
    }
}
