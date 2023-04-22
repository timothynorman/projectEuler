/*
 * Project Euler: Problem 2 
 * By considering the terms in the Fibonacci sequence whose values 
 * do not exceed four million, find the sum of the even-valued terms.
 * https://projecteuler.net/problem=2
 */

package ca.timnorman.projectEuler;

import java.util.ArrayList;

public class Question2 {

	public static void main(String[] args) {
		
		final int MAX_VALUE = 4000000;
		int termA = 1;
		int termB = 2;
		int sum = 0;
		
		// Create array of Fibonacci sequence up to MAX_VALUE
		ArrayList<Integer> fibonacci = new ArrayList<>();
		fibonacci.add(termA);
		fibonacci.add(termB);
		
		while(termB < MAX_VALUE) {
			fibonacci.add(termA + termB);
			int termNext = termA + termB; 
			termA = termB; 
			termB = termNext;
		}
		
		// Check for even terms and sum. 
		for(int i = 0; i < fibonacci.size(); i++) {
			if(fibonacci.get(i) % 2 == 0) {
				sum = sum + fibonacci.get(i);
			}
		}
		System.out.println(sum);
	}
}
