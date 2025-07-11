package com.mathool.mathool.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

// A class for our business logic
@Service
public class MathService {
    /**
     * Goal: Checks if the given number is a prime number.
     * Definition: A prime number is any number greater than 1 that is divisible only by 1 and itself.
     * Note: We make use of Java's BigInteger to handle large number value
     * The algorithm optimizes by checking divisibility only up to the square root of the number.
     * @param number The number to check (must be ≥ 0).
     * @return true if the number is prime, false otherwise.
     */
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

    /**
     * Goal: Calculates the factorial of the given number.
     * Definition: Factorial(n) = n * (n-1) * (n-2) * ... * 1
     * Note: We make use of Java's BigInteger to handle large number value
     * @param number The number to calculate the factorial for (must be ≥ 0).
     * @return The factorial as a BigInteger to handle large amount of result
     */
    public BigInteger calculateFactorial(BigInteger number) {
        // The factorial of 0 is automatically 1
        if (number.equals(BigInteger.ZERO)) return BigInteger.ONE;

        BigInteger result = BigInteger.ONE;

        // Multiply result by each number from 2 up to the given number
        for (BigInteger i = BigInteger.TWO; i.compareTo(number) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }

        return result;
    }
}
