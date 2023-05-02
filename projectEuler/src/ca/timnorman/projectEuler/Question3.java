/*
 * Project Euler: Question 3
 * What is the largest prime factor of the number 600851475143 ? 
 * https://projecteuler.net/problem=3
 */
package ca.timnorman.projectEuler;

import java.util.ArrayList;

public class Question3 {

	
    public static ArrayList<Long> findPrimeFactors(long num) {
        ArrayList<Long> factors = new ArrayList<>();
        long divisor = 2;
        
        while (num > 1) {
            while (num % divisor == 0) {
                factors.add(divisor);
                num /= divisor;
            }
            divisor++;
        }
        
        return factors;
    }
    
    public static void main(String[] args) {
        long num = 600851475143L;
        ArrayList<Long> primeFactors = findPrimeFactors(num);
        
        System.out.println("Prime factors of " + num + " are: ");
        for (long factor : primeFactors) {
            System.out.print(factor + " ");
        }
    }
}
