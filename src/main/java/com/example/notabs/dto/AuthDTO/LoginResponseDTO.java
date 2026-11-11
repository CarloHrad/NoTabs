package com.example.notabs.dto.AuthDTO;

import java.util.UUID;

public record LoginResponseDTO(
        String token,
        UUID idUsuario,
        String nome
) {}