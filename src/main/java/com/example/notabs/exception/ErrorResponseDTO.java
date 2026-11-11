package com.example.notabs.exception;

import java.time.LocalDateTime;

public record ErrorResponseDTO(
        String codigo,
        String mensagem,
        LocalDateTime timestamp
) {}