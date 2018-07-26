package com.learning.designpattern.behavioral.template;

public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();

        System.out.println("");
        game = new Football();
        game.play();
    }
}
