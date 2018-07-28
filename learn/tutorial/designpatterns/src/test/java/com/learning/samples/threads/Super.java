package com.learning.samples.threads;

class MySyncThread extends Thread{
    int count = 0;
    public void run(){
        System.out.println("run");
        synchronized (this) {
            System.out.println("inside synchronised");
            for(int i =0; i < 50 ; i++){
                count = count + i;
                //System.out.println("counting");
            }
            System.out.println("calling notify");
            notify();
        }
    }
}


public class Super{

    public static void inc(Integer input){ input++; }


    public static void main(String argv[]) {

        MySyncThread mySyncThread = new MySyncThread();
        mySyncThread.start();
        synchronized (mySyncThread) {
            System.out.println("waiting");
            try{
                mySyncThread.wait();
            }catch(InterruptedException e){
            }
            System.out.println(mySyncThread.count);

        }
    }
}