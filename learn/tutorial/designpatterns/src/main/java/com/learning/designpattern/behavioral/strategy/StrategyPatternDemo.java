package com.learning.designpattern.behavioral.strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext(new OperationAdd());
        System.out.println("10 + 5 = "+context.executeStrategy(10,5));
        context = new StrategyContext(new OperationSubstract());
        System.out.println("10 - 5 = "+context.executeStrategy(10,5));
        context = new StrategyContext(new OperationMultiply());
        System.out.println("10 * 5 = "+context.executeStrategy(10,5));
    }
}
