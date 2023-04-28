/*
 * Project Euler: Question 3
 * What is the largest prime factor of the number 600851475143 ? 
 * https://projecteuler.net/problem=3
 */
package ca.timnorman.projectEuler;

import java.util.ArrayList;
import java.util.Collections;

public class Queestion3 {

	
	public static void main(String[] args) {
		
		final long number = 99L;
		
		findPrimeFactors((findFactors(number)));
		Collections.sort(primeFactors);
		System.out.println(primeFactors);
		
		
	}

	static boolean isPrime(long numberToTest) {
		for(int i = 2; i < numberToTest/2; i++) {
			if(numberToTest % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static ArrayList<Long> findFactors(Long input){
		ArrayList<Long> factors = new ArrayList<>();
		
		for(int i = 2; i <= input/2; i++) {
			if(input % i == 0) {
				factors.add((long) i);
			}
		}
		return factors;
	}
	
	static void findPrimeFactors(ArrayList<Long> factors){
		for(Long factor : factors) {
			if(isPrime(factor)) {
				primeFactors.add(factor);
			}
			else {
				findPrimeFactors(findFactors(factor));
			}
		}
	}
}
