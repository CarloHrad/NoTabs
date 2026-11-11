package com.example.notabs.dto.DisciplinaDTO;

import com.example.notabs.domain.enums.StatusDisciplinaEnum;
import com.example.notabs.domain.enums.TipoMediaEnum;
import com.example.notabs.dto.HorarioDTO.HorarioResponseDTO;

import java.util.List;
import java.util.UUID;

public record DisciplinaResponseDTO(
        UUID idDisciplina,
        String nomeDisciplina,
        Integer periodo,
        String professor,
        String sala,
        Integer andar,
        String cor,
        StatusDisciplinaEnum status,
        TipoMediaEnum tipoMedia,
        Double mediaAtual,
        Double faltaParaAprovacao,
        Boolean arquivada,
        List<HorarioResponseDTO> horarios,
        Double projecaoPessimista,
        Double notaNecessariaRestantes,
        Boolean emRiscoReprovacao
) {}
