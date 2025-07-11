package com.mathool.mathool.dto;

import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigInteger;

// DTO class for returning the result of a prime number check.. Inherits number properties from BaseResponseDTO
public class PrimeResponseDTO extends BaseResponseDTO{
    private boolean isPrime;

    public PrimeResponseDTO(BigInteger number, boolean isPrime) {
        super(number);
        this.isPrime = isPrime;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }
}
