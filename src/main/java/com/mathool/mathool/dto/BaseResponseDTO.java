package com.mathool.mathool.dto;

import java.math.BigInteger;

// Acts as a base class for other responses DTOs
public abstract class BaseResponseDTO {
    private BigInteger number;

    public BaseResponseDTO(BigInteger number) {
        this.number = number;
    }

    public BigInteger getNumber() {
        return number;
    }

    public void setNumber(BigInteger number) {
        this.number = number;
    }
}
