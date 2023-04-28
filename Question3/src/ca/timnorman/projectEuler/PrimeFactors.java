package ca.timnorman.projectEuler;

import java.util.ArrayList;

public class PrimeFactors {

	private ArrayList<Long> primeFactors = new ArrayList<>();
	
	public PrimeFactors(long input) {
		findPrimeFactor(input);
	}
	
	public ArrayList<Long>getPrimeFactors() {
		return primeFactors;
	}
	
	
	private boolean isPrime(long numberToTest) {
		for(int i = 2; i <= numberToTest/2; i++) {
			if(numberToTest % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private void factorWithPrimes(Long input) {
		long factor2;
		
		for(long i = 2; i < input/2; i++) {
			if(isPrime(i)) {
				if(input % i == 0) {
					primeFactors.add(i);
					factor2 = input/i;
					if(isPrime(factor2)) {
						primeFactors.add(factor2);
					}
				}
			}
		}
	}
	
	private Long findPrimeFactor(Long input) {
		Long factor2;
		
		for(long i = 2; i < input/2; i++) {
			if(isPrime(i)) {
				if(input % i == 0) {
					primeFactors.add(i);
					factor2 = input/i;
					if(isPrime(factor2)) {
						primeFactors.add(factor2);
					}
					else {
						return findPrimeFactor(factor2);
					}
				}
			}
		}
		return null;
	}
}
