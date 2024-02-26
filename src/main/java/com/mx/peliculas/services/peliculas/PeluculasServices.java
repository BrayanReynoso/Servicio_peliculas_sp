package com.mx.peliculas.services.peliculas;

import com.mx.peliculas.controller.peliculas.Dto.PeliculasDto;
import com.mx.peliculas.models.genero.Genero;
import com.mx.peliculas.models.peliculas.Peliculas;
import com.mx.peliculas.repositories.genero.GeneroRepositorio;
import com.mx.peliculas.repositories.peliculas.PeliculaRepository;
import com.mx.peliculas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeluculasServices {
    @Autowired
    private PeliculaRepository repository;
    @Autowired
    private GeneroRepositorio generoRepositorio;

    @Transactional(readOnly = true)
    public Response<List<Peliculas>> getAll(){
        List<Peliculas> exist = repository.findAll();
        if (!exist.isEmpty()){
            return new Response<>(
                    this.repository.findAll(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                200,
                "Data is empty"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Peliculas> insert(Peliculas peliculas){
        Optional<Peliculas> exist = repository.findByNombre(peliculas.getNombre());
        if (!exist.isPresent()){
            return new Response<>(
                    this.repository.save(peliculas),
                    false,
                    200,
                    "Succesful insert"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Error in insert, Check your data!!"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Peliculas> update(Peliculas peliculas){
        Optional<Peliculas> exist = repository.findById(peliculas.getId());
        if (exist.isPresent()){
            return new Response<>(
                    this.repository.saveAndFlush(peliculas),
                    false,
                    200,
                    "Update is ok"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Error in update, check your data"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Peliculas> changeStatus(long id){
        Optional<Peliculas> exist = repository.findById(id);
        if (exist.isPresent()){
            exist.get().setStatus(!exist.get().getStatus());
            return new Response<>(
                    this.repository.saveAndFlush(exist.get()),
                    false,
                    200,
                    "Change status is ok"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Error in change status, Check your data!!"
        );
    }


    //Consultas
    @Transactional(readOnly = true)
    public Response<Object> findByDirector(Peliculas p) {
        if (p.getDirector() == null || p.getDirector().isEmpty()) {
            return new Response<>(
                    null,
                    true,
                    400,
                    "No se encontro el director"
            );
        }
        return new Response<>(
                this.repository.findByDirectorContaining(p.getDirector()),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(readOnly = true)
    public Response<Object> findPublicacionDateBetweenDate(PeliculasDto p){
        return new Response<>(
                this.repository.findByFechaPublicacionBetween(p.getStartDate(), p.getEndDate()),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<List<Peliculas>> findByGenero(Long id){
        Genero genero = this.generoRepositorio.findById(id).get();
        List<Peliculas> generos = this.repository.findAllByGenero(genero);
        if (!generos.isEmpty()){
            return new Response<>(
                    generos,
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "Error data is empty"
        );
    }

    @Transactional(readOnly = true)
    public Response<Object> findByOrderDate(){
        return new Response<>(
                this.repository.findByOrderByFechaPublicacionDesc(),
                false,
                200,
                "OK"
        );
    }
    @Transactional(readOnly = true)
    public Response<List<Peliculas>> findByNombreContraing(String nombre){
        List<Peliculas> peliculas = this.repository.findByNombreContaining(nombre);
        if (!peliculas.isEmpty()){
            return new Response<>(
                    peliculas,
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                false,
                200,
                "Data is empty"
        );
    }

}
