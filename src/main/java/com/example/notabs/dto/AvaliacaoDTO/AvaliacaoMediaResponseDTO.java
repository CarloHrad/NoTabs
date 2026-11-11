package com.example.notabs.dto.AvaliacaoDTO;

import java.util.UUID;

public record AvaliacaoMediaResponseDTO(
        UUID idAvaliacao,
        String nomeAvaliacao,
        Double notaObtida,
        Double notaMaxima,
        Double peso,
        Boolean concluida,
        Double notaNormalizada
) {}