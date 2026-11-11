package com.example.notabs.dto.UsuarioDTO;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record NovaMediaDTO(
        @NotNull(message = "A nova média mínima é obrigatória")
        @DecimalMin("0.0")
        @DecimalMax("10.0")
        Double novaMedia
) {}
