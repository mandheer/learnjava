package com.learning.samples;

import java.util.Arrays;

public class GreatestTime {
    public static void main(String[] args){
        int[] input = {0,2,4,4,9,9};
        if(isInvalid(input)){
            System.out.println("Impossible");
        }


    }

    static String getTime(int[] arr){
        Arrays.sort(arr);
        int h1=-1,h2=-1,M1=-1,M2=-1,s1=-1,s2=-1;
        int count=0,s_unit =0,s_ten=0, h_ten=0, h_unit=0;
        for(int in:arr){
            // finding max hours possible.
            Arrays.stream(arr).anyMatch(p -> p==0 || p==1 || p==2);


            if(in <= 2 && in > h1){
                h1=in;
                h_ten++;
            } else if(in > 2 && in <=4 && in > h2) {
                h2=in;
                h_unit++;
            } else if(in > 5 && in <=9){
                s_unit++;
                if(s_unit > 2){
                    return "Impossible";
                }
                M2 = M2 == -1 ? in : M2;
                s2 = s2 == -1 ? in : s2;
                if (M2 < s2 && M2 != -1 && s2 != -1) {// to form greatest unit in minute
                    int temp = M2;
                    M2 = s2;
                    s2 = temp;
                }
            } else if(in == 5){
                s_ten++;

            }
        }

        return null;
    }

    static boolean isInvalid(int[] arr){
        for (int q:
             arr) {
            if (q > 9 || q < 0) {
                return true;
            }
        }
        return false;
    }
}
