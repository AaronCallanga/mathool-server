package com.mathool.mathool.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Map;

// Class for better error response structure used to send meaningful error information to the client
public class ErrorResponse {
    // Formatted such as 2025-07-11 12:00:00, timestamp when the error occur
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private int statusCode;
    private String statusMessage;
    private Map<String, String> message;

    public ErrorResponse(LocalDateTime timestamp, int statusCode, String statusMessage, Map<String, String> message) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }
}
