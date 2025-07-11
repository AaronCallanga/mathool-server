package com.mathool.mathool.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

 /*
 * Unit tests for MathService class.
 * These tests directly verify the correctness of mathematical logic
 */
public class MathServiceUnitTest {

    private MathService mathService;

     /**
      * This method runs before each test.
      * It ensures a fresh instance of MathService is created for isolation.
      */
    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }


     /**
      * Test the isPrime method with known prime and non-prime numbers.
      * Sample cases:
      * - 2, 3, and 13 are prime
      * - 1 is not a prime
      * - 4 is not prime (divisible by 2)
      * - any negative number is not a prime
      */
    @Test
    void testIsPrime() {
        assertTrue(mathService.isPrime(BigInteger.valueOf(2)));
        assertTrue(mathService.isPrime(BigInteger.valueOf(3)));
        assertTrue(mathService.isPrime(BigInteger.valueOf(13)));
        assertFalse(mathService.isPrime(BigInteger.valueOf(1)));
        assertFalse(mathService.isPrime(BigInteger.valueOf(4)));
        assertFalse(mathService.isPrime(BigInteger.valueOf(-7)));
    }

     /**
      * Test the calculateFactorial method with small values:
      * Sample cases:
      * - factorial(0) = 1
      * - factorial(1) = 1
      * - factorial(5) = 120
      */
    @Test
    void testCalculateFactorial() {
        assertEquals(BigInteger.ONE, mathService.calculateFactorial(BigInteger.valueOf(0)));
        assertEquals(BigInteger.ONE, mathService.calculateFactorial(BigInteger.valueOf(1)));
        assertEquals(BigInteger.valueOf(120), mathService.calculateFactorial(BigInteger.valueOf(5)));
    }
}
