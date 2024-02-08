package com.mx.peliculas.services.genero;

import com.mx.peliculas.models.genero.Genero;
import com.mx.peliculas.repositories.genero.GeneroRepositorio;
import com.mx.peliculas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class GeneroServices {
    @Autowired
    private GeneroRepositorio repositorio;

    @Transactional(readOnly = true)
    public Response<List<Genero>> getAll(){
        return new Response<>(
                this.repositorio.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<Genero> getOne(long id){
        Optional<Genero> exist = repositorio.findById(id);
        if (exist.isPresent()){
            return new Response<>(
                    this.repositorio.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Genero no encontrado"
        );
    }
}
