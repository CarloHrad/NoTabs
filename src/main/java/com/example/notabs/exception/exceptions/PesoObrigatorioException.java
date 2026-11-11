package com.example.notabs.exception.exceptions;


import org.springframework.http.HttpStatus;

public class PesoObrigatorioException extends NegocioException {
    public PesoObrigatorioException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "472");
    }
}
