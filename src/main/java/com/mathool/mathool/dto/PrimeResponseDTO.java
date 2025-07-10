package com.mathool.mathool.dto;

import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigInteger;

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
