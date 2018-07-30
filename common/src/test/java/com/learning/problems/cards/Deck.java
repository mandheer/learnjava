package com.learning.problems.cards;

import java.util.ArrayList;

public class Deck<T extends Card> {
    private ArrayList<T> cards; //all cards, dealt or not
    private int dealtIndex = 0; // marks first undealt card

    public void setDeckOfCards(ArrayList<T> cards){
        this.cards = cards;
    }

    public void shuffle(){
        //TODO to be implemented
    }

    public int remainingCards(){
        return cards.size() - dealtIndex;
    }

    public T[] dealtHand(int number){
        //TODO to be implemented
        return null;
    }

    public T dealCard(){
        //TODO to be implemented
        return null;
    }
}
