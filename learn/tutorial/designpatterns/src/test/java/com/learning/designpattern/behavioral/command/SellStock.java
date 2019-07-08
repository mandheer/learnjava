package com.learning.designpattern.behavioral.command;

public class SellStock implements Order {

    private Stock stockName;

    public SellStock(Stock stockName){
        this.stockName = stockName;
    }

    @Override
    public void execute() {
        this.stockName.sell();
    }
}
