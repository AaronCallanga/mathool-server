package com.mathool.mathool.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigInteger;

// DTO class for returning the result of a factorial operation. Inherits number properties from BaseResponseDTO
public class FactorialResponseDTO extends BaseResponseDTO{
    // Serialize BigInteger to string
    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger factorial;

    public FactorialResponseDTO(BigInteger number, BigInteger factorial) {
        super(number);
        this.factorial = factorial;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public void setFactorial(BigInteger factorial) {
        this.factorial = factorial;
    }
}
