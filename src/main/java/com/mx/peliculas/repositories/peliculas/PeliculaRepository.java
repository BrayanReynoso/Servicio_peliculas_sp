package com.mx.peliculas.repositories.peliculas;

import com.mx.peliculas.models.genero.Genero;
import com.mx.peliculas.models.peliculas.Peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Peliculas, Long> {
    @Override
    Optional<Peliculas> findById(Long id);

    Optional<Peliculas> findByNombre(String nombre);


    List<Peliculas> findByNombreContaining(String nombre);

    List<Peliculas> findByDirectorContaining(String director);

    List<Peliculas> findByGenero(Genero genero);

    List<Peliculas> findByFechaPublicacionBetween(Date start, Date end);

    List<Peliculas> findByOrderByFechaPublicacionDesc();

}
