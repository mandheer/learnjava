package com.learning.designpattern.behavioral.template;

public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialize! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
