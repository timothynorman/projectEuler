/*
 * Project Euler: Question 7
 * What is the 10 001st prime number?
 */

package ca.timnorman.projectEuler;

public class Question7 {

	public static void main(String[] args) {

		int count = 0;
		long number = 1;
		
		while(count <= 10001) {
			if(isPrime(number)) {
				count++;
			}
			number++;
		}
		System.out.println(number-1);
	}
	
	private static boolean isPrime(long number) {
		for(long i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
