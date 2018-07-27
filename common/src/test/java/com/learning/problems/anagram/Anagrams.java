/**
 * common:com.learning.problems.anagram Created on Jan 2, 2016
 *
 * 
 */
package com.learning.problems.anagram;

/**
 * @author mandheer
 *         
 */
public class Anagrams {
	
	static int		size;
					
	static int		count;
					
	static char[]	charArray;
					
	/**
	 * @param args
	 *            
	 *            main Anagrams void
	 */
	public static void main(String[] args) {
		String input = "Mandheer";
		size = input.length();
		count = 0;
		charArray = new char[size];
		for (int j = 0; j < size; j++)
			charArray[j] = input.charAt(j);
		doAnagram(size);
	}
	
	public static void doAnagram(int newSize) {
		int limit;
		if (newSize == 1) // if too small, return;
			return;
		// for each position,
		for (int i = 0; i < newSize; i++) {
			doAnagram(newSize - 1); // anagram remaining
			if (newSize == 2) // if innermost,
				display();
			rotate(newSize); // rotate word
		}
	}
	
	// rotate left all chars from position to end
	public static void rotate(int newSize) {
		int i;
		int position = size - newSize;
		// save first letter
		char temp = charArray[position];
		// shift others left
		for (i = position + 1; i < size; i++)
			charArray[i - 1] = charArray[i];
		// put first on right
		charArray[i - 1] = temp;
	}
	
	public static void display() {
		System.out.print(++count + " ");
		for (int i = 0; i < size; i++)
			System.out.print(charArray[i]);
		System.out.println();
	}
}
