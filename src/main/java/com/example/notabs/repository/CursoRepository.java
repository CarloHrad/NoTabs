package com.example.notabs.repository;

import com.example.notabs.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
}