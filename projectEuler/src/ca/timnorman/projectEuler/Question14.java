/*
 * Project Euler: Question 14
 * Longest Collatz Sequence with a starting number under one million.
 */
package ca.timnorman.projectEuler;

import java.math.BigInteger;

public class Question14 {
    public static void main(String[] args) {
        // Declarations
        /**
         * Maximum starting value. No iterations above this.
         */
        int MAX_START_VALUE = 1_000_000;
        /**
         * Longest chain found so far.
         */
        int longestChain = 0;
        /**
         * The starting value which corresponds to the longestChain.
         */
        int longestStart = 1;
        /**
         * The value to apply to Collatz Sequence. Starts with 1 and increments to MAX_START_VALUE.
         */
        int n = 1;

        Collatz q14 = new Collatz();

        while(n <= MAX_START_VALUE){
            int chain = q14.collatzLength(BigInteger.valueOf(n));
            if (chain > longestChain){
                longestChain = chain;
                longestStart = n;
            }
            n++;
        }
        System.out.println("Longest chain is: " + longestChain);
        System.out.println("Longest start is: " + longestStart);
    }

    /**
     * A private class to contain all the methods used for a Collatz Series.
     */
    private static class Collatz {

        /**
         * Test to determine if value is even.
         * @param num The number to be tested if it's even.
         * @return Returns 'true' if even, and 'false' otherwise.
         */
        private boolean isEven(BigInteger num) {
            return num.remainder(new BigInteger("2")).equals(new BigInteger("0"));
        }

        /**
         * Performs the Collatz function for even values.
         * n = n/2
         * @param num An even number to be evaluated.
         * @return The value after applying the Collatz Even function.
         */
        private BigInteger even(BigInteger num) {
            return num.divide(new BigInteger("2"));
        }

        /**
         * Performs the Collatz function for odd values
         * n = 3n + 1
         * @param num An odd number to be evaluated.
         * @return The value after applying the Collatz Odd function.
         */
        private BigInteger odd(BigInteger num) {
            return num.multiply(new BigInteger("3")).add(new BigInteger("1"));
        }

        /**
         * Function to determine which Collatz function to use and directs the value to the
         * proper method.
         * @param n The value to be assessed in the Collatz Sequence.
         * @return The value after assessing as either an even or odd Collatz function.
         */
        private BigInteger collatzSequence(BigInteger n) {
            if (isEven(n)) {
                return even(n);
            }
            else {
                return odd(n);
            }
        }

        /**
         * Method to find the number of values in a Collatz sequence between the starting value and 1.
         * @param n The starting value in the Collatz Sequence.
         * @return The number of values in the Collatz Sequence between the starting value and 1.
         */
        private int collatzLength(BigInteger n){
            int length = 1;
            while (n.compareTo(new BigInteger("1")) > 0) {
                n = collatzSequence(n);
                length++;
            }
            return length;
        }
    }
}
