package com.mx.peliculas.controller.peliculas;

import com.mx.peliculas.controller.peliculas.Dto.PeliculasDto;
import com.mx.peliculas.models.genero.Genero;
import com.mx.peliculas.models.peliculas.Peliculas;
import com.mx.peliculas.services.genero.GeneroServices;
import com.mx.peliculas.services.peliculas.PeluculasServices;
import com.mx.peliculas.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-peli")
@CrossOrigin("*")
public class PeliculasController {

    @Autowired
    PeluculasServices services;
    @Autowired
    private GeneroServices generoServices;

    @GetMapping("/")
    public ResponseEntity<Response<List<Peliculas>>> getAll(){
        return new ResponseEntity<>(
                this.services.getAll(), HttpStatus.OK
        );
    }
    @GetMapping("/genero/")
    public ResponseEntity<Response<List<Genero>>> getAllGenero(){
        return new ResponseEntity<>(
                this.generoServices.getAll(), HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity<Response<Peliculas>> insert(@RequestBody PeliculasDto peliculas){
        return new ResponseEntity<>(
                this.services.insert(peliculas.getPeliculas()), HttpStatus.CREATED
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<Response<Peliculas>> update(@RequestBody PeliculasDto peliculasDto){
        return new ResponseEntity<>(
                this.services.update(peliculasDto.getPeliculas()), HttpStatus.OK
        );
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Response<Peliculas>> delete(@PathVariable("id") long id){
        return new ResponseEntity<>(
                this.services.changeStatus(id), HttpStatus.OK
        );
    }
}
