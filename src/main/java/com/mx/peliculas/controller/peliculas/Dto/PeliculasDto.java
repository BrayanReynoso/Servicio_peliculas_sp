package com.mx.peliculas.controller.peliculas.Dto;

import com.mx.peliculas.models.genero.Genero;
import com.mx.peliculas.models.peliculas.Peliculas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PeliculasDto {
    private long id;
    private String name;
    private String director;
    private String duracion;
    private Boolean status;
    private Genero genero;

    public Peliculas getPeliculas(){
        return new Peliculas(
                getId(),
                getName(),
                getDirector(),
                getDuracion(),
                getStatus(),
                getGenero()
        );
    }
}
