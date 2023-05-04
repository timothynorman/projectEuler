/*
 * Project Euler: Question 10
 * Find the sum of all the primes below two million.
 */

package ca.timnorman.projectEuler;

import java.util.ArrayList;

public class Question10 {

	public static void main(String[] args) {

		final int LIMIT = 2_000_000;
		long sum = 0;
		ArrayList<Integer> primeNumbers = new ArrayList<>();
		
		for(int i = 2; i < LIMIT; i++) {
			if(isPrime(i)) {
				primeNumbers.add(i);
			}
		}
		
		for(int number : primeNumbers) {
			sum += number;
		}
		
		System.out.println("The sum of all primes below " + LIMIT + " is " + sum);
		
	}
	
	/**
	 * Function to test if the given number is prime. It is am improvement where 
	 * factors up to the square root of the number are tested to improve evaluation 
	 * time for very large numbers (such as is required for this question.) 
	 * @param number
	 * @return True if the number is prime, and false otherwise. 
	 */
	private static boolean isPrime(int number) {
		for(int i = 2; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
