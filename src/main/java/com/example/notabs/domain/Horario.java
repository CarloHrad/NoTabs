package com.example.notabs.domain;

import com.example.notabs.domain.enums.DiaSemanaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idHora;

    @Enumerated(EnumType.STRING)
    private DiaSemanaEnum diaSemana;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;
}
