package com.learning.samples;

public class BeautifulNumber {

    public static void main(String[] args){
        String [] vowels = {"a","e","i","o","u"};
        int limit = 4;//Integer.parseInt(args[0]);
        System.out.println(beautiful(limit,vowels.length));
    }


    private static int beautiful(int limit,int vowelLen){
        if(limit==1){
            return vowelLen;
        } else {
            int count = 0;
            for(int i = vowelLen;i>0;i--){
                count = count + beautiful(limit-1,i);
            }
            return count;
        }
    }
}
