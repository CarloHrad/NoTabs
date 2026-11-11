package com.example.notabs.exception.exceptions;


import org.springframework.http.HttpStatus;

public class TipoMediaImutavelException extends NegocioException {
    public TipoMediaImutavelException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "471");
    }
}
