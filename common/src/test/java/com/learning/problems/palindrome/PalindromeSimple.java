/**
 * common:com.learning.problems.palindrome Created on Dec 30, 2015
 *
 * 
 */
package com.learning.problems.palindrome;

import java.util.Scanner;

/**
 * @author mandheer
 *         
 */
public class PalindromeSimple {
	public static void main(String args[]) {
		String original, reverse = "";
		Scanner in = new Scanner(System.in,"UTF-8");
		
		System.out.println("Enter a string to check if it is a palindrome");
		original = in.nextLine();
		
		int length = original.length();

		StringBuffer buf = new StringBuffer();
		for (int i = length - 1; i >= 0; i--) {
			buf.append(original.charAt(i));
		}
		reverse = buf.toString();
			
		if (original.equals(reverse))
			System.out.println("Entered string is a palindrome.");
		else
			System.out.println("Entered string is not a palindrome.");
			
	}
}
