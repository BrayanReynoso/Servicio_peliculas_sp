package com.mx.peliculas.repositories.genero;

import com.mx.peliculas.models.genero.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface GeneroRepositorio extends JpaRepository<Genero, Long> {
    @Override
    Optional<Genero> findById(Long id);
}
