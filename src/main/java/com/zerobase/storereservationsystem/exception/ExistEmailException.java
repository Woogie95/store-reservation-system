package com.zerobase.storereservationsystem.exception;

public class ExistEmailException extends RuntimeException {
    public ExistEmailException(String message) {
        super(message);
    }
}
