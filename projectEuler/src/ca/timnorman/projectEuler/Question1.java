/*
 * Project Euler: Problem 1
 * Find the sum of all multiples of 3 or 5 below 1000. 
 * https://projecteuler.net/problem=1
 */

package ca.timnorman.projectEuler;

public class Question1 {

	public static void main(String[] args) {
		
		// Declarations
		final int UPPER_LIMIT = 1000;
		int total = 0;
		
		for(int i = 1; i < UPPER_LIMIT; i++) {
			if(i % 3 == 0) {
				total = total + i;
			}
			else if(i % 5 == 0) {
				total = total + i;
			}
		}
		System.out.println(total);
		
	}

}
