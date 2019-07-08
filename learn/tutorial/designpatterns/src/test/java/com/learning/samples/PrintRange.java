package com.learning.samples;

/**
 * This class will Print the range from input. Starting from 1 to the given number.
 * And first line of output would contain the total number of input.
 *
 * Also, print 'foolee' for integer value is multiple of 5 and 3
 * print 'foo' for integer value is multiple of 3
 * print 'lee' for integer value is multiple of 5
 *
 */
public class PrintRange {
    public static void main(String args[]) throws Exception {
        System.out.println(args.length);
        for(String range: args){
            for(int i=1;i<Integer.parseInt(range);i++){
                if(i%3==0 && i%5==0){
                    System.out.println("foolee");
                } else if(i%3==0){
                    System.out.println("foo");
                } else if(i%5==0){
                    System.out.println("lee");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}
