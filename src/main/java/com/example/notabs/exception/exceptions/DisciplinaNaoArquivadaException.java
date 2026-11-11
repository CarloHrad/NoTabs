package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class DisciplinaNaoArquivadaException extends NegocioException {
    public DisciplinaNaoArquivadaException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "411");
    }
}
