package com.mathool.mathool.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigInteger;

public class PrimeAndFactorialResponseDTO extends BaseResponseDTO{
    private boolean isPrime;
    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger factorial;

    public PrimeAndFactorialResponseDTO(BigInteger number, boolean isPrime, BigInteger factorial) {
        super(number);
        this.isPrime = isPrime;
        this.factorial = factorial;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public void setPrime(boolean prime) {
        isPrime = prime;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public void setFactorial(BigInteger factorial) {
        this.factorial = factorial;
    }
}
