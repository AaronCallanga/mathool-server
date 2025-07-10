package com.mathool.mathool.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest  // Load all application context, making mockmvc use your real service
@AutoConfigureMockMvc
class MathControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCheckIfPrimeNumber() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/math/prime")
                .param("number", "7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(7))
                .andExpect(jsonPath("$.prime").value(true));
    }

    @Test
    void testCalculateFactorial() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/math/factorial")
                .param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(5))
                .andExpect(jsonPath("$.factorial").value(120));
    }

    @Test
    void testNegativeNumberForPrime_ShouldInvokeException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/math/prime")
                .param("number", "-7"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.statusMessage").value("VALIDATION_ERROR"))
                .andExpect(jsonPath("$.message['checkIfPrimeNumber.number']").value("Number must be positive or 0"));
    }

    @Test
    void testNegativeNumberForFactorial_ShouldInvokeException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/math/factorial")
                        .param("number", "-5"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.statusCode").value(400))
                .andExpect(jsonPath("$.statusMessage").value("VALIDATION_ERROR"))
                .andExpect(jsonPath("$.message['calculateFactorial.number']").value("Number must be positive or 0"));
    }
}