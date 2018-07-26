package com.learning.samples;

import java.util.Arrays;

/**
 * Given a number n, find the smallest number that has same set of digits as n and is greater than n.
 * If x is the greatest possible number with its set of digits, then print “not possible”.
 *
 * e.g.
 * Input:  n = "218765"
 * Output: "251678"
 *
 * Input:  n = "1234"
 * Output: "1243"
 *
 * Input: n = "4321"
 * Output: "Not Possible"
 *
 * Input: n = "534976"
 * Output: "536479"
 */
public class NextGreatestNumber {
    public static void main(String args []){
        String input = "2987654321" ;//args[0]; //"218765" --> "251678";
        findNextGreatest(input);
        findNext(input.toCharArray(),input.length());
    }

    int getIndexToReplace(char[] chars){
        for(int i=chars.length-1;i>=1;i--){
            if(chars[i-1]<chars[i]){
                return i-1;
            }
        }
        return -1;
    }

    int getNextNumberOnRight(int indexRef,char[] chars){
        int retIndex = indexRef;
        for(int i=indexRef;i<chars.length-1;i++){
            if(chars[indexRef] < chars[i] && chars[i] < chars[i+1]){
                retIndex = i;
            } else if(chars[indexRef] < chars[i+1] && chars[i] > chars[i+1]){
                retIndex = i+1;
            }
        }
        return  retIndex==indexRef ? -1 : retIndex;
    }

    void sortCharArray(int stIndex, int endIndex, char[] array){
        Arrays.sort(array,stIndex,endIndex);
    }

    //Utility function to swap values
    static void swapValues(int index1,int index2, char[] array){
        char c1 = array[index1];
        array[index1] = array[index2];
        array[index2] = c1;
    }

    // Given a number as a char array number[],
    // this function finds the next greater number.
    // It modifies the same array to store the result
    static void findNext(char ar[], int n)
    {
        int i;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--)
        {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0)
        {
            System.out.println("Not possible");
        }
        else
        {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++)
            {
                if (ar[j] > x && ar[j] < ar[min])
                {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swapValues( i - 1, min,ar);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i]);
        }
    }

    static void findNextGreatest(String input){
        char[] charSequence = input.toCharArray();
        NextGreatestNumber ngn = new NextGreatestNumber();
        int indexOfNextNumber = ngn.getIndexToReplace(charSequence);
        if(indexOfNextNumber == -1){
            System.out.println("Not possible");
        } else {
            int toReplace = ngn.getNextNumberOnRight(indexOfNextNumber,charSequence);
            if(toReplace != -1) {
                ngn.swapValues(indexOfNextNumber,toReplace,charSequence);
                ngn.sortCharArray(indexOfNextNumber+1,charSequence.length,charSequence);
                System.out.println(new String(charSequence).toString());
            }
        }
    }

}
