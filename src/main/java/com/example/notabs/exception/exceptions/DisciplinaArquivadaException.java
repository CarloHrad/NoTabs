package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class DisciplinaArquivadaException extends NegocioException {
    public DisciplinaArquivadaException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "410");
    }
}