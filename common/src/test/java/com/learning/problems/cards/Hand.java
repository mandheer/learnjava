package com.learning.problems.cards;

import java.util.ArrayList;

public class Hand<T extends Card> {
    protected ArrayList<T> cards = new ArrayList<T>();

    public int Score(){
        int score = 0;
        for(T card:cards){
            score+=card.value();
        }
        return score;
    }

    public void addCard(T card){
        this.cards.add(card);
    }
}
