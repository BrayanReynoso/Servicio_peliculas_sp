package com.mx.peliculas.controller.peliculas.Dto;

import com.mx.peliculas.models.genero.Genero;
import com.mx.peliculas.models.peliculas.Peliculas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Date fechaPublicacion;
    private Genero genero;
    private Date startDate;
    private Date endDate;
    public Peliculas getPeliculas(){
        return new Peliculas(
                getId(),
                getName(),
                getDirector(),
                getDuracion(),
                getStatus(),
               getFechaPublicacion(),
                getGenero()
        );
    }
    public Date getSatartDate(){
        try {
            return new SimpleDateFormat("yyyy/MM/dd").parse(String.valueOf(startDate));
        }catch (Exception e){
            return null;
        }
    }

}
