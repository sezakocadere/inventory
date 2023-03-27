package com.example.inventory.error;

public class UnexpectedValueException extends RuntimeException {
    public UnexpectedValueException(String message) {
        super(message);
    }
}
