package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class EmailNaoVerificadoException extends NegocioException {
    public EmailNaoVerificadoException(String message) {
        super(message, HttpStatus.FORBIDDEN, "480");
    }
}
