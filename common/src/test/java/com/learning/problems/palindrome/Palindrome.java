/**
 * common:com.learning.problems.palindrome Created on Dec 30, 2015
 *
 * 
 */
package com.learning.problems.palindrome;

import com.learning.problems.util.CommonUtil;

/**
 * @author mandheer
 *         
 */
public class Palindrome {
	public static void main(String[] args) {
		char seq[] = "GEEKSFORGEEKS".toCharArray();
		int n = seq.length;
		System.out.printf("The length of the LPS is %d", lps(seq, 0, n - 1));
		System.out.println("");
	}
	
	// Returns the length of the longest palindromic subsequence in seq
	static int lps(char[] seq, int i, int j) {
		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;
			
		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;
			
		// If the first and last characters match
		if (seq[i] == seq[j])
			return lps(seq, i + 1, j - 1) + 2;
			
		// If the first and last characters do not match
		return CommonUtil.max(lps(seq, i, j - 1), lps(seq, i + 1, j));
	}
}
