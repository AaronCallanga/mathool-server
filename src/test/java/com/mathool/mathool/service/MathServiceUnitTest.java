package com.mathool.mathool.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class MathServiceUnitTest {

    private MathService mathService;

    @BeforeEach
    void setUp() {
        mathService = new MathService();
    }

    @Test
    void testIsPrime() {
        assertFalse(mathService.isPrime(BigInteger.valueOf(1)));
        assertTrue(mathService.isPrime(BigInteger.valueOf(2)));
        assertTrue(mathService.isPrime(BigInteger.valueOf(3)));
        assertFalse(mathService.isPrime(BigInteger.valueOf(4)));
        assertTrue(mathService.isPrime(BigInteger.valueOf(13)));
    }

    @Test
    void testCalculateFactorial() {
        assertEquals(BigInteger.ONE, mathService.calculateFactorial(BigInteger.valueOf(0)));
        assertEquals(BigInteger.ONE, mathService.calculateFactorial(BigInteger.valueOf(1)));
        assertEquals(BigInteger.valueOf(120), mathService.calculateFactorial(BigInteger.valueOf(5)));
    }
}
