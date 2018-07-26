package com.learning.designpattern.behavioral.command;

public class BuyStock implements Order {

    private Stock stockName;

    public BuyStock(Stock stockName){
        this.stockName = stockName;
    }

    @Override
    public void execute() {
        this.stockName.buy();
    }
}
