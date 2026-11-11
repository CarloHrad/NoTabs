package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class ContaDesativadaException extends NegocioException {
    public ContaDesativadaException(String message) {
        super(message, HttpStatus.FORBIDDEN, "481");
    }
}
