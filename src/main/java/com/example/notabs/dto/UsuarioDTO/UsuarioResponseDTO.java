package com.example.notabs.dto.UsuarioDTO;

import com.example.notabs.dto.CursoDTO.CursoResponseDTO;

import java.util.UUID;

public record UsuarioResponseDTO(
        UUID idUsuario,
        String nome,
        String sobrenome,
        String email,
        CursoResponseDTO curso,
        Integer semestreAtual,
        boolean ativo,
        boolean emailVerificado
) {}
