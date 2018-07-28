package com.learning.designpattern.behavioral.visitor;

public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard mouse);
    public void visit(Monitor mouse);
}
