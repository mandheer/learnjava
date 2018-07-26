package com.learning.designpattern.j2ee.compositeentity;

public class EntityClient {
    private CompositeEntity ce = new CompositeEntity();

    public void printData(){
        for(String str:ce.getData()){
            System.out.println("Data : "+str);
        }
    }

    public void setData(String data1, String data2){
        ce.setData(data1,data2);
    }
}
