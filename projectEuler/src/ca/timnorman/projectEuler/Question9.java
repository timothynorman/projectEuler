/*
 * Project Euler: Question 9
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

package ca.timnorman.projectEuler;

public class Question9 {

	public static void main(String[] args) {

		for(int a = 1; a < 998; a++) {
			for(int b = 1; b < 998; b++) {
				int c = 1000 - a - b; 
				if(Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2))  {
					System.out.println(a * b * c);
				}
			}
		}
	}

}
