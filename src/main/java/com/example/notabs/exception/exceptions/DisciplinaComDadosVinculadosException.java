package com.example.notabs.exception.exceptions;

import org.springframework.http.HttpStatus;

public class DisciplinaComDadosVinculadosException extends NegocioException {
    public DisciplinaComDadosVinculadosException(String message) {
        super(message, HttpStatus.BAD_REQUEST, "442");
    }
}