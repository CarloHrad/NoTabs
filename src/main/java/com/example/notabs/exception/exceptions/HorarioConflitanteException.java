package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class HorarioConflitanteException extends NegocioException {
    public HorarioConflitanteException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "450");
    }
}