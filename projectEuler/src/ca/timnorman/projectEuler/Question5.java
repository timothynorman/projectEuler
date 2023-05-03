/*
 * Project Euler: Question 5
 * What is the smallest positive number that is evenly divisible by 
 * all of the numbers from 1 to 20?
 * 
 * Using the Prime-Factors Method to find the Lowest Common Multiple (LCM.) 
 * i.e. Factor all numbers from 1-20 down to their primes, and then gather "sets" 
 * of matching factors. Multiplying all of the values of these prime number 
 * sets will give the LCM. 
 */
package ca.timnorman.projectEuler;

import java.util.ArrayList;

public class Question5 {

	public static void main(String[] args) {
		/**
		 * An array list to hold all the "sets" of prime factors from all 
		 * numbers. 
		 */
		ArrayList<Integer> setsOfPrimes = new ArrayList<>();
		
		/**
		 * The maximum number in the series in which we are searching for the 
		 * LCM of. In this case it was 1-20 so the maximum number is 20. 
		 */
		final int MAX_NUM = 20;
		
		/**
		 * Populates an 2D ArrayList of all prime factors for every number between 
		 * 1 and 'MAX_NUM'. 
		 */
		ArrayList<ArrayList<Integer>> allPrimes = new ArrayList<>();
		for(int i = 2; i <= MAX_NUM; i++) {
			allPrimes.add(findPrimeFactors(i));
		}
		
		/**
		 * For each prime factor, add it to the list of 'setsOfPrimes' and set the 
		 * next instance of that factor to 0 for the prime factors of the other numbers
		 * (i.e. gathering up sets of matching prime factors from the other numbers.) 
		 */
		for(ArrayList<Integer> numberPrimes : allPrimes) {
			for(Integer primeFactor : numberPrimes) {
				if(primeFactor !=0) {	// Prevents instances set to 0 in later factors from being included. 
					setsOfPrimes.add(primeFactor);
					for(ArrayList<Integer> removePrimes : allPrimes) {
						if(removePrimes.indexOf(primeFactor) != -1) {
							removePrimes.set(removePrimes.indexOf(primeFactor), 0);	// Removes first instance of primeFactor from other sets. 
						}
					}
				}
			}
		}
		
		System.out.println("The lowest common multiple of all numbers between 1 and " + MAX_NUM + " is " + calculateLcm(setsOfPrimes));
	}

	/**
	 * Calculates the Lowest Common Multiple (LCM) by multiplying all the values 
	 * of sets of prime factors. 
	 * @param primeSets Sets of prime factors from the range of numbers specified.
	 * @return lcm The lowest common multiple. 
	 */
	private static int calculateLcm(ArrayList<Integer> primeSets) {
		int lcm = 1; 
		for(Integer i : primeSets) {
			lcm *= i;
		}
		return lcm;
	}
	
	/**
	 * Populates an ArrayList with prime factors of a number. 
	 * @param num The number of which to find all the prime factors of. 
	 * @return primeFactors An ArrayList of all prime factors of the given number. 
	 */
	private static ArrayList<Integer> findPrimeFactors(int num){
		ArrayList<Integer> primeFactors = new ArrayList<>();
		int divisor = 2;
		
		while(num > 1) {
			while(num % divisor == 0) {
				primeFactors.add(divisor);
				num /= divisor;
			}
			divisor++;
		}
		return primeFactors;
	}
}
