package com.example.notabs.repository;

import com.example.notabs.domain.extra.TokenRevogado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;

public interface TokenRevogadoRepository extends JpaRepository<TokenRevogado, String> {

    void deleteByDataExpiracaoBefore(Instant limite);
}
