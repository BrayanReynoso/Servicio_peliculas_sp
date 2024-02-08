package com.mx.peliculas.repositories.peliculas;

import com.mx.peliculas.models.peliculas.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Long> {
    @Override
    Optional<Peliculas> findById(Long id);

    Optional<Peliculas> findByNombre(String nombre);
}
