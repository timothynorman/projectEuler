/*
 * Project Euler: Question 3
 * What is the largest prime factor of the number 600851475143 ? 
 * https://projecteuler.net/problem=3
 */

package ca.timnorman.projectEuler;

public class Question3 {
	
	public static void main(String[] args) {

		final long NUMBER = 600851475143L;
		
		PrimeFactors factors = new PrimeFactors(1002);
		System.out.println(factors.getPrimeFactors());
		
	}
}
