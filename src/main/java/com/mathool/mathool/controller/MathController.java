package com.mathool.mathool.controller;

import com.mathool.mathool.dto.FactorialResponseDTO;
import com.mathool.mathool.dto.PrimeAndFactorialResponseDTO;
import com.mathool.mathool.dto.PrimeResponseDTO;
import com.mathool.mathool.service.MathService;
import jakarta.validation.constraints.PositiveOrZero;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/math")     // Base API endpoint
@Validated     // Enables Validation
public class MathController {

    @Autowired
    private MathService mathService;

    /**
     * Endpoint: GET /api/v1/math/prime
     * Description: Checks if the given number is a prime number.
     * Validation: Number must be zero or positive.
     * Response: JSON with number and isPrime boolean
     */
    @GetMapping("/prime")
    public ResponseEntity<PrimeResponseDTO> checkIfPrimeNumber(
            @PositiveOrZero(message = "Number must be positive or 0") @RequestParam(name = "number", defaultValue = "0") BigInteger number
    ) {
        boolean isPrime = mathService.isPrime(number);

        PrimeResponseDTO response = new PrimeResponseDTO(number, isPrime);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

     /**
     * Endpoint: GET /api/v1/math/factorial
     * Description: Calculates the factorial of a given number.
     * Validation: Number must be zero or positive.
     * Response: JSON with number and factorial result
     */
    @GetMapping("/factorial")
    public ResponseEntity<FactorialResponseDTO> calculateFactorial(
            @PositiveOrZero(message = "Number must be positive or 0") @RequestParam(name = "number", defaultValue = "0") BigInteger number
    ) {
        BigInteger factorial = mathService.calculateFactorial(number);

        FactorialResponseDTO response = new FactorialResponseDTO(number, factorial);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    /*
     * Endpoint: GET /api/v1/math/prime-factorial
     * Description: Returns both the prime check and factorial of the given number.
     * Validation: Number must be zero or positive.
     * Response: JSON with number, isPrime boolean, and factorial result
     */
    @GetMapping("/prime-factorial")
    public ResponseEntity<PrimeAndFactorialResponseDTO> checkIfPrimeAndCalculateFactorial(
            @PositiveOrZero(message = "Number must be positive or 0") @RequestParam(name = "number", defaultValue = "0") BigInteger number
    )
    {
        boolean isPrime = mathService.isPrime(number);
        BigInteger factorial = mathService.calculateFactorial(number);

        PrimeAndFactorialResponseDTO response = new PrimeAndFactorialResponseDTO(number, isPrime, factorial);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
