package com.example.notabs.dto.HorarioDTO;

import com.example.notabs.domain.enums.DiaSemanaEnum;

import java.time.LocalTime;
import java.util.UUID;

public record HorarioResponseDTO(
        UUID idHora,
        DiaSemanaEnum diaSemana,
        LocalTime horaInicio,
        LocalTime horaFim
) {}
