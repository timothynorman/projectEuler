/*
 * Project Euler: Question 6
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
package ca.timnorman.projectEuler;

public class Question6 {

	public static void main(String[] args) {

		final int MAX_NUM = 100; 

		System.out.println(Math.abs(sumOfSquares(MAX_NUM) - squareOfSums(MAX_NUM)));
	}
	
	private static int sumOfSquares(int num) {
		int sumOfSquares = 0;
		for(int i = 1; i <= num; i++) {
			sumOfSquares += i*i;
		}
		return sumOfSquares;
	}
	
	private static int squareOfSums(int num) {
		int squareOfSums = 0;
		for(int i = 1; i <= num; i++) {
			squareOfSums += i;
		}
		squareOfSums *= squareOfSums;
		return squareOfSums;
	}
}
