package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class EmailJaCadastradoException extends NegocioException {
    public EmailJaCadastradoException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "400");
    }
}