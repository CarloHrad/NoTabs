package com.example.notabs.dto.MediaDTO;

import com.example.notabs.domain.enums.TipoMediaEnum;
import com.example.notabs.dto.AvaliacaoDTO.AvaliacaoMediaResponseDTO;

import java.util.List;

public record MediaResponseDTO(
        TipoMediaEnum tipoMedia,
        Double mediaAtual,
        Double mediaAprovacao,
        Double faltaParaAprovacao,
        List<AvaliacaoMediaResponseDTO> avaliacoes,
        Double projecaoPessimista,
        Double notaNecessariaRestantes,
        Boolean emRiscoReprovacao
) {}