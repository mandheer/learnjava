/**
 * common:com.learning.problems.palindrome Created on Dec 30, 2015
 *
 * 
 */
package com.learning.problems.palindrome;

/**
 * @author mandheer
 *        
 */
import java.util.Scanner;

class PalindromeOptimized {
	public static void main(String args[]) {
		String inputString;
		Scanner in = new Scanner(System.in,"UTF-8");
		
		System.out.println("Input a string");
		inputString = in.nextLine();
		
		int length = inputString.length();
		int i, begin, end, middle;
		
		begin = 0;
		end = length - 1;
		middle = (begin + end) / 2;
		
		for (i = begin; i <= middle; i++) {
			if (inputString.charAt(begin) == inputString.charAt(end)) {
				begin++;
				end--;
			} else {
				break;
			}
		}
		if (i == middle + 1) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}
	}
}
