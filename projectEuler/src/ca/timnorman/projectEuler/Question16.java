package ca.timnorman.projectEuler;

import java.math.BigInteger;

public class Question16 {
    public static void main(String[] args) {

        BigInteger num = BigInteger.valueOf(2);
        num = num.pow(1000);
        BigInteger quotientAndRemainder[];
        BigInteger sum = BigInteger.valueOf(0);

        while (num.compareTo(BigInteger.ZERO) != 0){
            quotientAndRemainder = num.divideAndRemainder(BigInteger.TEN);
            sum = sum.add(quotientAndRemainder[1]);
            num = quotientAndRemainder[0];
        }

        System.out.printf("Sum of digits is: %d", sum);
    }
}
