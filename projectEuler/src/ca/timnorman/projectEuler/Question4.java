/*
 * Project Euler Question 4
 * Find the largest palindrome made from the product of two 
 * 3-digit numbers.
 */

package ca.timnorman.projectEuler;

public class Question4 {

	public static void main(String[] args) {
		int largestPalindrome = 0;
		
		for(int i = 100; i < 1000; i++) {
			for(int j = 100; j < 1000; j++) {
				int product = i * j;
				if(isPalindrome(product)) {
					if(product > largestPalindrome) {
						largestPalindrome = product;
					}
				}
			}
		}
		System.out.println("Largest palindrome of two 3-digit numbers is " + largestPalindrome);

	}
	
	/**
	 * Checks if a number is a palindrome by taking the last digit (using %10) 
	 * and adding it to reverseNumber. Next iteration multiplies by 10 to shift 
	 * digits and make room for the next number.
	 * @param number The number to test for being a palindrome. 
	 * @return
	 */
	private static boolean isPalindrome(int number) {
		int num = number;
		int originalNumber = number;
		int reverseNumber = 0;
		int remainder = 0;
		
		while( num != 0) {
			remainder = num % 10;
			reverseNumber = reverseNumber * 10 + remainder;
			num /= 10;
		}
		
		if(reverseNumber == originalNumber) {
			return true;
		}
		return false;
	}
	
	

}
