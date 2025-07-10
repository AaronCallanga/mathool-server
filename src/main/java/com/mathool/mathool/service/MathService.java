package com.mathool.mathool.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MathService {
    // Define: Prime number is any number that is only divisible by itself or 1
    // integer limit value = -2147483648 to 2147483647
    // We use BigInteger to handle large amount of number
    public boolean isPrime(BigInteger number) {
        // compareTo results to -> -1 if a < b, 0 if a == b, 1 if a > b
        // Checks if number's value is 0, 1, or any negative number, it is not a prime number
        if (number.compareTo(BigInteger.TWO) < 0) return false;
        if (number.equals(BigInteger.TWO)) return true;

        BigInteger sqrtOfNumber = number.sqrt();

        // This will loop as long as i <= sqrtOfNumbmer
        /* Why sqrtOfNumber?
                Remember: Prime is only divisible by itself or 1. So, if a number below a prime number able to divide it, it is not a prime number.
                This reduces the number of iteration which results to more optimize solution
        */
        for (BigInteger i = BigInteger.TWO; i.compareTo(sqrtOfNumber) <= 0; i = i.add(BigInteger.ONE)) {
            // if number is divisible by i (an even number), it is not a prime number
            if (number.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    public BigInteger calculateFactorial(BigInteger number) {
        // The factorial of 0 is automatically 1
        if (number.equals(BigInteger.ZERO)) return BigInteger.ONE;

        BigInteger result = BigInteger.ONE;

        // This will loop as long as i <= number
        for (BigInteger i = BigInteger.TWO; i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }

        return result;
    }
}
