package com.example.notabs.dto.TarefaDTO;

import com.example.notabs.domain.enums.StatusTarefaEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record TarefaResponseDTO(
        UUID idTarefa,
        String nomeTarefa,
        String descricao,
        LocalDate dataEntrega,
        LocalTime horaEntrega,
        LocalDateTime dataConclusao,
        StatusTarefaEnum status,
        String nomeDisciplina
) {}
